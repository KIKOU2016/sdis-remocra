# Red�finit les acc�s de l'utilisateur postgres remocra
# P�riodicit� : A DETERMINER

cd $(dirname $0)

echo "Red�finit les acc�s de l'utilisateur postgres remocra"
psql remocra -f /home/postgres/remocra_db/030_acces.sql
if [ $? = 1 ]; then
  echo "Erreur lors de la red�finition des acc�s de l'utilisateur postgres remocra"
  exit $?
fi

