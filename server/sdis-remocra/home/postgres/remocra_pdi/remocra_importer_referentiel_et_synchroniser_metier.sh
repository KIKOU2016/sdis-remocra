# T�che principale de r�cup�ration des donn�es Postgresql distantes, d'import en base locale et de synchronisation des donn�es m�tier.
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"synchronisations/import_remocra" -job:"importer_referentiel_et_synchroniser_metier" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

