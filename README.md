![alt text](https://github.com/Tigercocotiger/Nobelium-Client/blob/main/src/main/resources/Images/client/Nobelium.png?raw=true)
# Nobélium coté client 
*Vous pouvez aussi aller voir [le côté Client](https://github.com/Tigercocotiger/Nobelium-Client)*

installer le projet sous Eclipse : 


    IMPORTER LE PROJET DEPUIS UNE ARCHIVE :

        Placez l'archive dans le dossier ou vous souhaitez travailler
        Decompresser la puis ouvrez Eclipse

        File > Import ...
        Deroulez Maven
        Selectionner "Existing Maven Projects"

        Dans la fenetre "Maven Projects"

        Choissisez le dossier du projet a importer
        Verifiez que le fichier pom.xml est bien coche

        Puis Finish


    SI IL Y A DES ERREURS : JavaSE n'est pas correctement configure

    Remarque: essayez d'utiliser une des dernieres versions de JavaSE puisque nous utiliser des concepts des dernieres   
        versions de Java
    Par exemple : Java 8 ne sera surement pas compatible.

        Pour regler le probleme de JDK: 

        Clique droit sur le projet > Properties (tout en bas)

        Sur la gauche cliquez sur Java Build Path
        Puis aller dans "Libraries"

        Dans Modulepath cliquer sur votre JRE puis "edit"
        Derouler "executing environment" et prenez la derniere version du JavaSE

        Finish > Apply And Close



Et voila vous etes prete a lancer notre projet!
