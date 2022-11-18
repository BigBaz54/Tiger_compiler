# Premier rapport d'activité
## Apprentissage de Tiger
La première étape a été pour les trois membres du groupe de s’imprégner du langage Tiger afin d’en maîtriser la syntaxe, pour pouvoir comprendre la grammaire donnée en exemple dans l’un des manuels. Étant familiers avec le langage OCaml, nous n’avons pas eu trop de difficulté pour apprendre Tiger.

## Construction de la grammaire
Nous avons décidé de créer un fichier "lexer" pour y définir notre lexique et un fichier "parser" pour y écrire notre grammaire.

Nous sommes sont partis de la grammaire de la documentation, l’avons implémentée dans ANTLR, puis avons commencé à l’améliorer en vue de la rendre LL(1).
Nous avons supprimé la récursivité à gauche en réécrivant les règles qui en contenaient et avons factorisé les règles à gauche. Nous avons aussi imposé un ordre au sein des règles pour s'assurer que les opérations les moins prioritaires apparaissent bien dans des noeuds moins profonds de l'arbre que celles qui le sont plus.
Une fonctionnalité d'ANTLR4 indique lors de la création du parser si la grammaire utilisée est LL(1) et cela nous permet savoir si l’on doit modifier la grammaire sans avoir à faire la preuve formelle. Au départ notre grammaire n’était pas LL(1) à cause du dédoublement d’une règle qui a eu lieu à l’étape de dérécursivation, cela a été corrigé mais elle ne l'est toujours pas, malgré la factorisation entre les règles avec des membres gauches différents mais qui commençaient par le même token.

Nous avons également ajouté les règles qui permettent de gérer les appels aux fonctions standards du langage, comme "print"

## Programmes de test
Nous avons créé des exemples de programmes en Tiger répartis en 4 catégories afin de tester notre grammaire aux différentes étapes de sa conception : 
- les programmes corrects (un exemple [ici](../examples/good/facto.tig))
- ceux avec des erreurs lexicales (un exemple [ici](../examples/bad_lex/wrong_id.tig))
- ceux avec des erreurs syntaxiques (un exemple [ici](../examples/bad_syn/missing_quote.tig))
- ceux avec des erreurs sémantiques (un exemple [ici](../examples/bad_sem/dict.tig))

Les tests sur les programmes corrects nous ont ainsi permis de corriger notre grammaire, qui ne reconnaissait pas correctement les entiers par exemple. Chaque aspect de la grammaire et chaque règle a été utilisée dans les tests : celles qui concernent les opérateurs de calcul et les priorités entre eux ainsi que les opérateurs booléens, celles qui concernent les déclarations de variables, de fonctions, de nouveaux types, de block "for" et "while", celles qui concernent les affectations, les appels de fonctions.

## Lexique et grammaire
Notre [lexique](../TigerLexer.g4)

Notre [grammaire](../TigerParser.g4)