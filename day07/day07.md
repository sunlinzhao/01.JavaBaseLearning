1. String 字符串类 创建

- String不是基本数据类型，是一种引用类型；
- String代表一组不可改变的Unicode字符序列；
- String类对象的内容一旦被初始化，不能再改变；
- String类是final修饰的终结类，不能产生子类；

> - 静态方式创建: String str="abc"; 在方法区常量池中产生唯一个字符串对象，如果有另外一个引用指向了相同的字符串，则两个引用变量的地址相同;
> - 动态方式创建:String str=new string("abc”); 在堆内存中会产生一个不同的对象, 会产生两个对象;

2. 构造方法

new String();
new String("abc");
new String(char类型数组)
new String(char类型数组，数组下标起始位置,取出数组的长度);
new String(byte类型数组)
new String(byte类型数组，数组下标起始位置，取出数组的长度);

3. 连接符操作

```java
String str5 = str4 + 10 + 20 + 'd'; // 字符串连接操作
System.out.println(str5);

String str6 = "abcabc";
System.out.println(str6==str1+str1); // false
System.out.println(str6=="abc"+"abc"); // true
```

4. 常用方法

* length()：返回int类型的值，获取字符串长度
* equals(String)：判断两个字符串中的字面量值是否相等
* equalsIgnoreCase(String)：不区分大小写比较字面量值是否相等
* indexOf(int):
* indexOf(String):查找给定值在字符串中第一次出现的下标位置。如果值不存在，则返回-1
* indexOf(int,int):
* indexOf(string,int):查找给定值在字符串中给定索引位置开始，第一次出现的下标位置。如果值不存
  在，则返回-1
* lastIndexOf(int):
* lastIndexOf(String):查找给定值在字符串中最后一次出现的下标位置。如果值不存在，则返回-1
* lastIndexOf(int,int):
* lastIndexOf(String,int):查找给定值在字符串中给定索引位置开始，最后一次出现的下标位置。如果值
  不存在，则返回-1
* toUpperCase():将字符串中所有字符都转换为大写
* toLowerCase():将字符串中所有字符都转换为小写
* charAt(int): 返回下标引处的char值
* subString(int):对字符串进行截取，从指定索引位置开始，一直截取到最后
* subString(int,int):对字符串进行截取，从指定开始位置，截取到结束位置(不包含结束位置)
* trim(): 将字符串前后空格去除
* concat(String): 字符串连接和+实现相同的功能, 如果字符串是nul值不能使用，并且只能传字符串参数，其他类型不可以使用
* getBytes(): 将字符串转换成byte数组
* toCharArray(): 将字符串转换成char数组
* contains(String): 判断在字符串中是否包含给定值，返回boolean类型的值
* startsWith(string): 判断字符串是否以给定值做为开始
* startsWith(string,int): 判断字符串从索引位置，是否以给定值做为开始
* endsWith(string): 判断字符串是否以给定值做为结束
* replace(char,char): 对字符串指定字符，使用新的字符进行替换
* replace(charsequence, charsequence): 对字符串指定的字符序列，使用新的字符序列进行替换
* replaceAll(String,string): 按正则表达式要求，将给定的值替换满足正则的字符串
* split(string): 按给定的正则表达式，将字符串分隔成字符串数组
* maches(): 判断字符串是否可以匹配给定的正则表达式
* contentEquals(Charsequence)
* contentEquals(StringBuffer): 字符串和 StringBuffer 或者字符序列比较内容

5. 正则表达式

又叫作规则表达式。是一种文本模式，包括普通字符和特殊字符(元字符)。正则使用单个字符串来描述、匹配一系列某个句法规则的字符串，通常用来检索、替换符合某个模式(规则)的文本。目的:

- 给定一个正则表达式，判断给定的字符串是否符合正则表达式的过滤逻辑；【检索】
- 通过正则表达式，从字符串中获取我们想要的特定部分；【提取】

> 学习网站: https://codejiaonang.com/
>
> 测试网站: https://regexr-cn.com/ https://regex101.com/



6. StringBuffer

内容可变的字符串类，使用 StringBuffer 来对字符串的内容进行动态操作，不会产生额外的对象。初始时，默认是有16个字符来做为缓冲区;

构造方法：

> new StringBuffer();
> new StringBuffer(String);
> new StringBuffer(int);
> new StringBuffer(charsequence):

常用方法：

- append(): 在当前StringBuffer对象上，追加其他内容
- capacity(): 返回当前容量
- length(): 返回长度
- setCharAt(int,char): 将给定索引位置的字符设置为第二个参数给定的值
- reverse(): 将StringBuffer内容反转
- delete(int,int): 删除StringBuffer从指定索引开始(包含)到结束(不包含)的字符串
- tostring(): 将StringBuffer转成字符串
- insert(int,object): 在指定索引位置，插入给定值
- replace(int,int,string): 将指定的字符串替换到起始位置(包含)和结束位置(不包含)中
- deleteCharAl(int): 删除指定索引位置的字符


7. StringBulider

提供了和StringBuffer相同的API。

> StringBuffer 的方法，都有synchronized修饰，是线程安全的；
>
> StringBuilder的方法，没有synchronized修饰，非线程安全的。

如果是单线程操作字符串相关处理 StringBuilder 的效率最高。

String、StringBuffer、StringBuilder区别：

- String和StringBuffer区别: 一个是常量，一个是变量。String是一个final修饰的终结类,不能产生子类，是使用final的byte数组来存储值，所以一旦创建不能改变。如果经常对字符串进行修改、删除或者插入操作，建议使用stringBuffer效率更高；
- StringBuffer和StringBuilder区别: 一个是有线程安全的，一个是非线程安全的；
