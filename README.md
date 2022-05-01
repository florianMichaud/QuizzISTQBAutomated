# Welcome to QuizzISTQBAutomated!

Bonjour à tous et à toutes ! Le but de ce projet est d'automatiser la soumission d'un quizz d'entrainement sur la plateforme https://hightest.nc/  et d'en récupérer le résultat depuis https://www.mohmal.com.


# Technologies utilisées

* Java en tant que langage de programmation
* Sélénium comme Librairie d'automatisation de test de non rÃ©gression
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

# Principes de fonctionnement
Le robot sélénium va sur le site de mail temporaire mohmal.com. Il y récupère une adresse mail aléatoire temporaire pour ensuite pouvoir passer le test sur la plateforme https://hightest.nc. Une fois le quizz réalisé, le robot revient sur mohmal.com, se connecte à l'adresse récupérée plsu tôt et vient récupérer ses résultats.

# Evolution du projet
Le projet initial était prévu pour fonctionner avec yopmail.com. Néanmoins, ce dernier détectant le robot et lui fournissant un captcha, il nous a fallu changer de fournisseur d'adresse mail jetables pour garder un test 100% front. Sinon, nosu aurions pu passer par une api.

# Point de focus pour l'évolution du projet
* Nous utilisons, dans ce projet, le webdrivermanager fournit par bonigarci. Visiblement il fournit un chromedriver fonctionnant sur chrome 97 alors que la version actuelle est 100, à voir les conséquences que ça peut avoir.
* Amélioration de la robustesse de la sélection d'éléments.
* Variabilisation de la langue du Quiz sélectionnée par le robot. Pour le moment, seul la langue française est choisie.
* Amélioration de la gestion des erreurs
* Abstraction du fournisseur mail pour le rendre interchangeable selon une sélection préalablement définie.