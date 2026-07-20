#!/bin/bash

# Définition des variables
APP_NAME="Ordinateur"
SRC_DIR="src/main"
WEB_DIR="src/main/webapp"
BUILD_DIR="build"
LIB_DIR="lib"


TOMCAT_WEBAPPS="/home/itu/Documents/apache-tomcat-9.0.104/webapps"
SERVLET_API_JAR="$LIB_DIR/servlet-api.jar"
POSTGRESQL_JAR="$LIB_DIR/postgresql.jar"
GSON_JAR="$LIB_DIR/gson-2.3.1.jar"

# Nettoyage et création du répertoire temporaire
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR/WEB-INF/classes
mkdir -p $BUILD_DIR/WEB-INF/lib

# Compilation des fichiers Java avec le JAR des Servlets et PostgreSQL
find $SRC_DIR -name "*.java" > sources.txt
javac -cp "$SERVLET_API_JAR:$POSTGRESQL_JAR:$GSON_JAR" -d $BUILD_DIR/WEB-INF/classes @sources.txt 
rm sources.txt

# Copier les fichiers web (web.xml, JSP, etc.)
cp -r $WEB_DIR/* $BUILD_DIR/

# Copier le driver PostgreSQL dans WEB-INF/lib
cp $POSTGRESQL_JAR  $BUILD_DIR/WEB-INF/lib/
cp $GSON_JAR  $BUILD_DIR/WEB-INF/lib/

# Générer le fichier .war dans le dossier build
cd $BUILD_DIR || exit
jar -cvf $APP_NAME.war *
cd ..

# Déploiement dans Tomcat
cp -f $BUILD_DIR/$APP_NAME.war $TOMCAT_WEBAPPS/

echo ""

echo "Déploiement terminé. Redémarrez Tomcat si nécessaire."

echo ""
