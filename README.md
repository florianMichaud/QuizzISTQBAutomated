# Welcome to QuizzISTQBAutomated!

Bonjour � tous et � toutes ! Le but de ce projet est d'automatiser la soumission d'un quizz d'entrainement sur la plateforme https://hightest.nc/  et d'en r�cup�rer le r�sultat depuis https://www.mohmal.com.


# Technologies utilis�es

* Java en tant que langage de programmation
* S�l�nium comme Librairie d'automatisation de test de non régression
* Cucumber comme framework de BDD
* Maven en tant qu'outil d'int�gration continue
* JUnit comme launcher de test

# Pattern de conception
Le pattern de conception utilis� est celui du <b>P</b>age <b>O</b>ject <b>M</b>odel. 
Ainsi, le package est actuellement compos� de 3 packages :
* <b>TestRunner</b> qui contient une surcouche du driver S�l�nium pour sa configuration ainsi que le runner de test bas� sur JUnit.
* <b>Steps</b> contenant les �tapes Cucumber appelant les page object.
* <b>Page</b> contenant les objets int�ragissant avec la page HTML.

![image](https://blog.expandtesting.com/design-patterns/page-object-model/images/page-objects-concepts.png)

# Principes de fonctionnement
Le robot s�l�nium va sur le site de mail temporaire mohmal.com. Il y r�cup�re une adresse mail al�atoire temporaire pour ensuite pouvoir passer le test sur la plateforme https://hightest.nc. Une fois le quizz r�alis�, le robot revient sur mohmal.com, se connecte � l'adresse r�cup�r�e plsu t�t et vient r�cup�rer ses r�sultats.

# Evolution du projet
Le projet initial �tait pr�vu pour fonctionner avec yopmail.com. N�anmoins, ce dernier d�tectant le robot et lui fournissant un captcha, il nous a fallu changer de fournisseur d'adresse mail jetables pour garder un test 100% front. Sinon, nosu aurions pu passer par une api.

# Point de focus pour l'�volution du projet
* Nous utilisons, dans ce projet, le webdrivermanager fournit par bonigarci. Visiblement il fournit un chromedriver fonctionnant sur chrome 97 alors que la version actuelle est 100, � voir les cons�quences que �a peut avoir.
* Am�lioration de la robustesse de la s�lection d'�l�ments.
* Variabilisation de la langue du Quiz s�lectionn�e par le robot. Pour le moment, seul la langue fran�aise est choisie.
* Am�lioration de la gestion des erreurs
* Abstraction du fournisseur mail pour le rendre interchangeable selon une s�lection pr�alablement d�finie.