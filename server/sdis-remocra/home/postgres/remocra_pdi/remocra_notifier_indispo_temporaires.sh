# T�che principale de cr�ation des notifications de d�but et de fin d'indisponibilit� temporaire d'hydrant
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"maintenance/indisponibilites_temporaires" -job:"creer_notifications_indisponibilites" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

