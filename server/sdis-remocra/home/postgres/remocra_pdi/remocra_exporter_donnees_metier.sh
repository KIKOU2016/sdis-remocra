# T�che principale de synchronisation des donn�es m�tier vers OraclePar th�matique :- G�n�ration d'un script sql de mise � jour � partir de la date de la derni�re synchronisation- R�cup�ration (copie) des documents �ventuelsPuis, toutes th�matiques m�tier confondues- G�n�ration d'un fichier ZIP englobant les sql et les documents- Cr�ation d'un fichier MD5 du ZIP- D�p�t du ZIP et du MD5 sur le serveur FTP

# P�riodicit� : A DETERMINER
cd /home/postgres/pdi
sh kitchen.sh -rep:"ref_pdi_remocra" -dir:"synchronisations/export_remocra/exporter_metier" -job:"exporter_donnees_metier" -user:admin -pass:admin -level:Error -param:"PDI_FICHIER_PARAMETRE=/home/postgres/remocra_pdi/remocra.properties"

