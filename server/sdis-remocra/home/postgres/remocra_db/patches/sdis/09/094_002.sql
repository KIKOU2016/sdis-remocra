--
-- SDIS09
-- 
-- Gestion d'un type d'anomalie sur les PIBI : DEBIT_EGAL_0
--  * Automatiquement par un trigger sur la table remocra.hydrant_pibi pour une donnée de qualité
-- 
-- Remarque : les points des anomalies "classiques" liées au débit et à la pression ont été redéfinis à 0 ('PRESSION_INSUFF', 'PRESSION_TROP_ELEVEE', 'PRESSION_DYN_INSUFF', 'PRESSION_DYN_TROP_ELEVEE', 'DEBIT_INSUFF', 'DEBIT_TROP_ELEVE', 'DEBIT_INSUFF_NC') 
--

begin;





-- Executé après remocra.calcul_debit_pression car :
-- "SQL specifies that multiple triggers should be fired in time-of-creation order. PostgreSQL uses name order, which was judged to be more convenient."
CREATE OR REPLACE FUNCTION remocra.calcul_debit_pression_09(id_hydrant bigint)
  RETURNS void AS
$BODY$
DECLARE
	p_anomalie_id integer;
	p_rec remocra.hydrant_pibi%ROWTYPE;
BEGIN
	select * into p_rec from remocra.hydrant_pibi where id = id_hydrant;

	-- Suppression des anomalies débit/pression des règles communes
	delete from remocra.hydrant_anomalies where hydrant=id_hydrant and anomalies in (select id from remocra.type_hydrant_anomalie where code IN('PRESSION_INSUFF', 'PRESSION_TROP_ELEVEE', 'PRESSION_DYN_INSUFF', 'PRESSION_DYN_TROP_ELEVEE', 'DEBIT_INSUFF', 'DEBIT_TROP_ELEVE', 'DEBIT_INSUFF_NC'));

	-- Suppression des anciennes anomalies
	delete from remocra.hydrant_anomalies where hydrant = p_rec.id and anomalies in (select id from remocra.type_hydrant_anomalie where code IN('DEBIT_EGAL_0'));

	-- Ajout des anomalies
	if (p_rec.debit = 0) then
		select id into p_anomalie_id from remocra.type_hydrant_anomalie where code = 'DEBIT_EGAL_0';
		insert into remocra.hydrant_anomalies (hydrant,anomalies) values (p_rec.id, p_anomalie_id);
	end if;
END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;
ALTER FUNCTION remocra.calcul_debit_pression_09(bigint) OWNER TO postgres;
GRANT EXECUTE ON FUNCTION remocra.calcul_debit_pression_09(bigint) TO public;
GRANT EXECUTE ON FUNCTION remocra.calcul_debit_pression_09(bigint) TO postgres;
GRANT EXECUTE ON FUNCTION remocra.calcul_debit_pression_09(bigint) TO remocra;



CREATE OR REPLACE FUNCTION remocra.trg_calcul_debit_pression_09() RETURNS trigger AS
$BODY$
DECLARE
	p_rec record;
BEGIN
	if (TG_OP = 'DELETE') then
		p_rec = OLD;
	else
		p_rec = NEW;
	end if;
	perform remocra.calcul_debit_pression_09(p_rec.id);

    RETURN p_rec;
END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;
ALTER FUNCTION remocra.trg_calcul_debit_pression_09() OWNER TO postgres;

DROP TRIGGER if exists trig_debit_pression_09 on remocra.hydrant_pibi;
CREATE TRIGGER trig_debit_pression_09 AFTER INSERT OR UPDATE ON remocra.hydrant_pibi FOR EACH ROW EXECUTE PROCEDURE remocra.trg_calcul_debit_pression_09();




alter table remocra.hydrant_pibi disable trigger trig_debit_pression;




commit;

