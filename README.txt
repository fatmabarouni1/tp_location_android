TP LOCATION DE VOITURES - PROJET ANDROID STUDIO

1. Decompressez le ZIP.
2. Dans Android Studio : File > Open.
3. Selectionnez le dossier "tp_location_android" (celui qui contient settings.gradle).
4. Attendez la fin de la synchronisation Gradle.
5. Si Android Studio demande le SDK 35, acceptez son installation ou modifiez compileSdk/targetSdk vers une version installee.
6. Ouvrez Tools > Device Manager > Create Virtual Device.
7. Choisissez un telephone (par exemple Pixel 7) et une image Android.
8. Selectionnez l'emulateur dans la barre du haut.
9. Cliquez sur Run > Run 'app'.

Parcours de test :
- Entrez un nom.
- Cliquez sur "Louer une voiture".
- Selectionnez une voiture.
- Entrez le nombre de jours.
- Calculez le prix puis validez.
- Consultez le contrat puis le profil.

Package Java : com.example.tpmobile
Min SDK : 24
Compile/Target SDK : 35

IMPORTANT - GRADLE WRAPPER
Le projet contient la configuration Gradle complete. Le fichier binaire gradle-wrapper.jar ne peut pas etre inclus automatiquement ici.
Sous Windows, avant la premiere ouverture, double-cliquez sur :
INSTALL_GRADLE_WRAPPER_WINDOWS.bat
Il telechargera le fichier officiel Gradle 8.9 depuis le depot Gradle.
Ensuite ouvrez le projet dans Android Studio.
