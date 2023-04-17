# pokemon
Réalisé par : 
=>NAJALI Chaimaa
=>BAKAROU Hajar

**Description général :**

On a réalisé une application Android qui affiche une liste de Pokémon à partir d'une API. L'application utilise Volley pour effectuer des requêtes HTTP pour récupérer les données de l'API. Les données sont stockées dans des objets ListPokemon et ListPokemonDetails, qui sont utilisés pour remplir des listes et des vues de détails. L'application comporte également des boutons de navigation pour permettre à l'utilisateur de passer à la page précédente ou suivante de la liste de Pokémon.

**Description des fichiers:**

_1**-AdapterModel :**_

Cette classe  étend la classe "BaseAdapter". Cela signifie qu'elle est utilisée pour créer un adaptateur personnalisé pour une liste ou une grille d'éléments dans l'application Android.

  _Variables et méthodes de cette classe :_

  "layoutInflater" est une variable de type "LayoutInflater" utilisée pour convertir une mise en page XML en un objet Java.
  "Arrayproduit" est une variable de type "ArrayList" qui contient des objets "ListPokemon".
  "url" est une variable de type "String" utilisée pour stocker l'URL de l'image du Pokémon.
  "img" est une variable de type "ImageView" utilisée pour afficher l'image du Pokémon.
  "getCount()" renvoie le nombre d'éléments dans la liste.
  "getItem()" renvoie l'élément à la position spécifiée dans la liste.
  "getItemId()" renvoie l'ID de l'élément à la position spécifiée dans la liste.
  "getView()" est la méthode principale qui crée la vue pour chaque élément dans la liste. Elle utilise la mise en page XML "listpokemon" pour créer la vue et afficher le nom et l'image du Pokémon en utilisant les valeurs stockées dans les objets "ListPokemon" de "Arrayproduit". Elle utilise également la bibliothèque de chargement d'images "Glide" pour charger l'image à partir de l'URL stockée dans la variable "url".
  
  _**2-AdapterModelDetails:**_
  
Cette classe  étend la classe  "BaseAdapter". Elle est utilisée pour adapter une liste de données "ListPokemonDetails" à une vue.

  _Variables globales utilisées dans cette classe sont :_

  "layoutInflater" de type LayoutInflater qui est utilisée pour charger la vue de chaque élément dans la liste.
  "Arrayproduit" de type ArrayList qui contient les données de la liste.
  "url" de type String qui contient l'URL de l'image à charger.
  "img" de type ImageView qui est utilisée pour afficher l'image chargée.
  Le constructeur de la classe prend en paramètres une activité et un ArrayList de données "ListPokemonDetails".

  La méthode "getCount" retourne le nombre d'éléments dans la liste.

  La méthode "getItem" retourne l'élément à l'index spécifié.

  La méthode "getItemId" retourne l'ID de l'élément à l'index spécifié.

  La méthode "getView" est appelée pour chaque élément dans la liste. Elle prend en paramètres l'index de l'élément, la vue en cours (si elle existe) et le ViewGroup parent. Elle retourne la vue de l'élément actuel.

  Dans la méthode "getView", la vue est d'abord initialisée avec la méthode "inflate" de "LayoutInflater". Ensuite, les données de l'élément sont récupérées à partir de "Arrayproduit" et sont affichées dans les TextView correspondants.

  Finalement, la vue est retournée pour être affichée à l'utilisateur.
  
_**3-ListPokemon :**_

Ce fichier contient la classe ListPokemon qui représente un objet Pokemon dans l'application. Il a trois propriétés privées : textUrl, textName et image. La propriété textUrl stocke l'URL du pokemon, la propriété textName stocke le nom du pokemon et la propriété image stocke l'URL de l'image du pokemon.

La classe a deux méthodes publiques pour accéder et modifier les valeurs des propriétés. Le constructeur de la classe prend trois arguments pour initialiser les propriétés textName, textUrl et image de l'objet Pokemon.

_**4-ListPokeemonDetails:**_

La classe "ListPokemonDetails"  contient les attributs suivants :

"ability" de type String
"is_hidden" de type String
"slot" de type String
La classe contient également des méthodes pour accéder et modifier ces attributs :

"getAbility()" qui renvoie la valeur de "ability"
"setAbility(String bility)" qui modifie la valeur de "ability"
"getIshidden()" qui renvoie la valeur de "is_hidden"
"setIshidden(String is_hidden)" qui modifie la valeur de "is_hidden"
"getSlot()" qui renvoie la valeur de "slot"
"setSlot(String slot)" qui modifie la valeur de "slot"
Enfin, la classe contient un constructeur avec trois paramètres de type String ("ability", "is_hidden" et "slot") qui permet d'initialiser les attributs de la classe.

_**5-MainActivity**_

C'est la classe de l'application Android qui récupère la liste des Pokémons à partir de l'API PokeAPI et les affiche dans une ListView. L'application permet également de naviguer dans la liste en cliquant sur les boutons "previous" et "next". Enfin, en cliquant sur un élément de la liste, l'utilisateur est redirigé vers une autre activité qui affiche les détails du Pokémon sélectionné.

Le'application utilise la bibliothèque Volley pour effectuer des requêtes HTTP et récupérer les données JSON de l'API. Elle utilise également la classe AdapterModel pour afficher les données dans la ListView. Les classes ListPokemon et ListPokemonDetails sont utilisées pour stocker les données de chaque élément de la liste et les détails du Pokémon sélectionné, respectivement.

_**6-MainActivity2**_

Il permet d'afficher les détails d'un Pokémon sélectionné dans l'activité précédente ( MainActivity ).

Lorsque l'activité est créée, elle récupère l'URL et l'image du Pokémon sélectionné à partir de l'intention. L'image est affichée à l'aide de la bibliothèque Glide.

Ensuite, une requête Volley est utilisée pour récupérer les détails du Pokémon à partir de l'URL. Les détails sont stockés dans une liste d'objets ListPokemonDetails qui contient le nom de l'habilité, si elle est cachée ou non, et l'emplacement de l'habilité dans le tableau des capacités.

Une fois que les détails ont été récupérés, ils sont affichés dans une ListView à l'aide d'un adaptateur personnalisé AdapterModelDetails.


  




 
