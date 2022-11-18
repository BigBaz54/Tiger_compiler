# Premier rapport d'activité
La première étape a été pour les trois membres du groupe de s’imprégner du langage Tiger afin d’en maîtriser la syntaxe, pour pouvoir comprendre la grammaire donnée en exemple dans l’un des manuels. Étant familiers avec le langage OCaml, nous n’avons pas eu trop de difficulté pour apprendre Tiger.

Nous avons décidé de créer un fichier « lexer » pour y définir notre lexique et un fichier « parser » pour y écrire notre grammaire.

Nous sommes sont partis de la grammaire de la documentation, l’avons implémentée dans ANTLR, puis avons commencé à l’améliorer en vue de la rendre LL(1).
Nous avons supprimé la récursivité à gauche en réécrivant les règles qui en contenaient et avons factorisé la grammaire à gauche. La dérécursivation a fait apparaître des règles donnant le mot vide ce qui compliquera la preuve que la grammaire est LL(1) mais nous avons décidé de les laisser pour le moment.
En effet ANTLR4 indique lors de la création du parser si la grammaire utilisée est LL(1) et cela nous permet savoir si l’on doit modifier la grammaire sans avoir à faire la preuve formelle. Pour l’instant notre grammaire n’est pas LL(1) à cause du dédoublement d’une règle qui a eu lieu à l’étape de dérécursivation donc nous explorons différentes pistes qui permettraient de régler cette anomalie.

Nous avons créé des exemples de programmes en Tiger répartis en 4 catégories afin de tester notre grammaire aux différentes étapes de sa conception : 
- les programmes corrects
- ceux avec des erreurs lexicales
- ceux avec des erreurs syntaxiques
- ceux avec des erreurs sémantiques
Les tests sur les programmes corrects nous ont ainsi permis de corriger notre grammaire, qui ne reconnaissait pas les entiers par exemple.

Notre [lexique](../TigerLexer.g4)

Notre [grammaire](../TigerParser.g4)