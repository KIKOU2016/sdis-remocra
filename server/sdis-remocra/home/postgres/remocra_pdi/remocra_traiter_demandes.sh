# T�che principale de r�cup�ration et d'execution des demandes de traitements effectu�es via l'interface de lancement de l'applicatif.
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"demandes" -job:"traiter_demandes" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

