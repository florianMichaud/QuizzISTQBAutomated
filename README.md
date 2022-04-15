# Welcome to QuizzISTQBAutomated!

Bonjour à tous et à toutes ! Le but de ce projet est d'automatiser la soumission d'un quizz d'entraînement sur la plateforme https://hightest.nc/  et d'en récupérer le résultat depuis https://yopmail.com/.


# Technologies utilisées

* Java en tant que langage de programmation
* Sélénium comme Librairie d'automatisation de test de non régression
* Cucumber comme framework de BDD
* Maven en tant qu'outil d'intégration continue
* JUnit comme launcher de test

# Pattern de conception
Le pattern de conception utilisé est celui du <b>P</b>age <b>O</b>ject <b>M</b>odel. 
Ainsi, le package est actuellement composé de 3 packages :
* <b>TestRunner</b> qui contient une surcouche du driver Sélénium pour sa configuration ainsi que le runner de test basé sur JUnit.
* <b>Steps</b> contenant les étapes Cucumber appelant les page object.
* <b>Page</b> contenant les objets intéragissant avec la page HTML.

![image](https://blog.expandtesting.com/design-patterns/page-object-model/images/page-objects-concepts.png)