# Purge les �l�ments g�n�r�s par le syst�me en fonction de param�tres d'anciennet� (nombre de jours)
# P�riodicit� : A DETERMINER

cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"maintenance/purge" -job:"purger" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

