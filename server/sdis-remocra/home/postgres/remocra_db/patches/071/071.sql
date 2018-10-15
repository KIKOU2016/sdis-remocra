begin;

set statement_timeout = 0;
set client_encoding = 'UTF8';
set standard_conforming_strings = off;
set check_function_bodies = false;
set client_min_messages = warning;
set escape_string_warning = off;

set search_path = remocra, pdi, public, pg_catalog;

--------------------------------------------------
-- Versionnement du patch et vérification
--
create or replace function versionnement_dffd4df4df() returns void language plpgsql AS $body$
declare
    numero_patch int;
    description_patch varchar;
begin
    -- Métadonnées du patch
    numero_patch := 71;
    description_patch := 'Symbologie PEI rendue paramétrable';

    -- Vérification
    if (select numero_patch-1 != (select max(numero) from remocra.suivi_patches)) then
        raise exception 'Le numéro de patch requis n''est pas le bon. Dernier appliqué : %, en cours : %', (select max(numero) from remocra.suivi_patches), numero_patch; end if;
    -- Suivi
    insert into remocra.suivi_patches(numero, description) values(numero_patch, description_patch);
end $body$;
select versionnement_dffd4df4df();
drop function versionnement_dffd4df4df();

--------------------------------------------------
-- Contenu réel du patch début
--


-- Paramétrage de la méthode de calcul du numéro
DELETE FROM remocra.param_conf where cle in ('HYDRANT_SYMBOLOGIE_METHODE');
INSERT INTO remocra.param_conf(cle, description, valeur, version, nomgroupe) VALUES ('HYDRANT_SYMBOLOGIE_METHODE', 'Symbologie des PEI (ex : 77, 83). <a href="https://github.com/atolcd/sdis-remocra/blob/master/docs/Symbologie_PEI.adoc" target="_blank">Symbologies disponibles</a>','GEN', NULL, 'Points d''eau');


--
-- Contenu réel du patch fin
--------------------------------------------------

commit;

