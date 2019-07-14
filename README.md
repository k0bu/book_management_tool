# book_management_tool

To test the bookInterface, use the below command for CMD.

### Command Prompt:
```bash
java -cp .;Recommend.jar Test.java
```

## package bookInterface

Elementを要素、Aggregationを集合体としてのインターフェースをまず用意し、それぞれBook、BookShelfで実装するようにした。この時Element内ではなにも抽象メソッドを持たせていないため、インターフェースとしての役割はほとんどないが、最終的に本だけでない対象物に対しても用いることができるようにしたいため、とりあえずその準備だけをしておいた。このことは「要素」という単位以上に分割することができないことより、基本的に保持するべき機能が考えつかなかった為である。具体的には今回であれば本には複数のパラメータを考えられるが、場合によってはパラメータは1つであったりとし、抽象メソッドが包括的な名前になることができないため定義は一旦省いた。Elementとは対照的にAggregationでは5つの抽象メソッド、
```java
  public void addElement(Element e);
  public void setAggregation(List<Element> elements);
  public void removeElement(Element e);
  public void removeAggregation();
  public boolean existElement(Element e);
```
を用意した。addElementでは1つのElementをAggregationに加える事を、setAggregationではAggregation自身を入れ替える事を、removeElementではElementをAggregationから除く事を、removeAggregationではAggregation自身を削除する事を、そして最後にexistElementをElementがAggregation内に存在しているかどうかを確認する意味として定義した。
これらの定義は最低限、集合体であれば用意されるべき機能として考え、用意した。