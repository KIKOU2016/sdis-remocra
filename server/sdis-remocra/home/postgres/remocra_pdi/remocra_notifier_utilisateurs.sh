# T�che principale de notification des utilisateurs � partir de la lecture de la table contenant les emails � notifier
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"maintenance/notification" -job:"notifier_utilisateurs" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

