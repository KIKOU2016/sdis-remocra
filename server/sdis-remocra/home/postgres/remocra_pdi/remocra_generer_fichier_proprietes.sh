# Cr�ation automatique du fichier de param�trage de Pentaho Data Integration (pdi) � partir de la la table de configuration de l'applicatif
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"maintenance" -job:"generer_fichier_proprietes" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

