# Cr�ation et alimentation du sch�ma remocra_referentiel
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"synchronisations/import_remocra/creer_et_alimenter_tables_referentiels_geographiques" -job:"creer_et_alimenter_tables_postgresql" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

