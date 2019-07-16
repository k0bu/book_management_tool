# book_management_tool

To test the bookInterface, use the below command for CMD.
For some kind of reason you can not compile nor run the script through powershell.

### Command Prompt:
```bash
javac -cp .;Recommend.jar Test.java
java -cp .;Recommend.jar Test
```

## package bookInterface

`Element.java`を要素、`Aggregation.java`を集合体としてのインターフェースをまず用意し、それぞれ`Book.java`、`BookShelf.java`で実装するようにした。この時Element内ではなにも抽象メソッドを持たせていないため、インターフェースとしての役割はほとんどないが、最終的に本だけでない対象物に対しても用いることができるようにしたいため、とりあえずその準備だけをしておいた。このことは「要素」という単位以上に分割することができないことより、基本的に保持するべき機能が考えつかなかった為である。具体的には今回であれば本には複数のパラメータを考えられるが、場合によってはパラメータは1つであったりとし、抽象メソッドが包括的な名前になることができないため定義は一旦省いた。Elementとは対照的にAggregationでは5つの抽象メソッド、
```java
  public void addElement(Element e);
  public void setAggregation(List<Element> elements);
  public void removeElement(Element e);
  public void removeAggregation();
  public boolean existElement(Element e);
```
を用意した。`addElement`では1つのElementをAggregationに加える事を、`setAggregation`ではAggregation自身をまるごと入れ替える事を、`removeElement`では指定したElementをAggregationから除く事を、`removeAggregation`ではAggregation自身をまるごと削除する事を、そして最後に`existElement`を指定したElementがAggregation内に存在しているかどうかを確認する意味として定義した。
これらの定義は最低限、集合体であれば用意されるべき機能として考え、用意した。

`Book.java`では、`Element.java`を実装している。`Book.java`では`Map<String, String>`を用いてBookの詳細を格納する変数`_detail`を宣言している。これは詳細を示す変数を作ることよりも拡張性を持たせるためである。しかし、このことによって文字列以外の数字などの値を格納するには、使用者側で調整するなどの必要が生じてしまう所は懸念点である。この変数`_detail`を起点として、`Book.java`ではメソッドを実装しており、それらは、
```java
  public boolean addParametre(String key, String value);  
  public boolean removeParametre(String key);
  public boolean modifyParametre(String key, String value);
  public void setBookDetail(Map<String, String> bookDetail);
  public Map<String,String> getBookDetail();
  public boolean existsParametre(String key);
  public boolean equalsDetail(String key, String value);
  public boolean equals(Book b);
```
である。これらは上から、詳細を一つ加える`addParametre`、指定した詳細の一つを削除する`removeParametre`、指定した詳細の一つの文字列を変化を変化する`modifyParamtre`、詳細をまるごと設定する`setBookDetail`、詳細をまるごと取り出す`getBookDetail`、指定した詳細が存在するか確認する`existsParametre`、指定した詳細の内容が存在するか確認する`existsDetail`、本が一致するか確認する`equals`を実装したメソッドである。また、使用するかわからないがほとんどのメソッドがこの時点では返り値の型をbooleanとして、その操作が可能だったかどうかを判別するために付随している。

`BookShelf.java`では、`Aggregation.java`を実装している。こちらではBookの集合体であるBooksを`List<Book>`で表現しており、また宣言した`_bookShelf`に対して操作を行うメソッドをクラス内では用意されている。以下に`BookShelf.java`内で実装したメソッドを示す。
```java
  @Override
  public void setAggregation(List<Element> books);
  @Override
  public void addElement(Element e);
  @Override
  public void removeElement(Element e);
  @Override
  public boolean existElement(Element e);
  @Override
  public void removeAggregation();
  public List<Book> getBooks();
  public List<Book> filterBooks(String key, String value);
```
これらは上から、インターフェースAggregationで用意した`setAggregation`、`addElement`、`removeElement`、`existElement`、`removeAggregation`、Bookの集合体を格納しているList<Book>を返り値とする`getBooks`、指定した内容のBookの集合体を取り出してくる`filterBooks`を実装したメソッドである。

