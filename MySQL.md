# MySQL

[TOC]



## 数据库

### 创建数据库

```sql
CREATE DATABASE [IF NOT EXISTS] db_name 
		[create_specification [,create_specification]...]
```

> create_specification:
>
> [DEFAULT] CHARACTER SET charset_name
>
> [DEFAULT] COLLATE collation_name

1. CHARACTER SET:指定数据库采用的字符集，如果不指定享符集，默认utf8

2. COLLATE:指定数据库字符集的校对规则（常用的utf8bin、utf8 general ci注
   意默认是utf8 general ci))

### 查看、删除数据库

```sql
-- 显示数据库语句
SHOW DATABASES;

-- 显示数据库创建语句
SHOW CREATE DATABASES db_name;

-- 数据库删除语句
DROP DATABASE [IF EXISTS] db_name;
```

### 备份恢复数据库

DOS 命令行

```shell
-- 备份恢复数据库
mysqldump -u 用户名 -p -B 数据库1 数据库2 数据库n > 文件名.sql

mysqldump -u 用户名 -p 数据库 表1 表2 > 文件名.sql
```

MySQL 命令行

```sql
-- 恢复数据库
Source 文件名.sql
```

## 表

### 创建

```sql
CREATE TABLE table_name
(field1 datatype,
field2 datatype,
field3 datatype
)character set字符集 collate校对规则 engine引擎
-- field:指定列名datatype:指定列类型（字段类型）
-- character set:如不指定则为所在数据库字符集
-- collate:如不指定则为所在数据库校对规则
-- engine:引擎
```

### 删除、修改

> 删除

```sql
ALTER TABLE table_name
DROP (column); -- 删除列

DESC table_name;  -- 查看表结构
```

> 添加

```sql
ALTER TABLE table_name
ADD (column datatype [DEFAULT expr]
    [,colomn datatype]...
    ); -- 添加
```

> 修改

```sql
ALTER TABLE table_name
MODIFY (column datatype [DEFAULT expr]
       [,column datatype]...
       );  -- 修改
```

> 修改表名

```sql
RENAME TABLE old_name TO new_name;
```

> 修改字符集

```sql
ALTER TABLE table_name CHARACTER SET 字符集;
```



## MySQL 数据类型

<table>
	<tr>
	    <th colspan="2">分类</th>
	    <th>类型</th>  
	</tr >
	<tr >
	    <td rowspan="8">数值类型</td>
	    <td rowspan="5">整型</td>
	    <td>tinyint[一个字符]</td>
	</tr>
	<tr>
	    <td>smallint[2个字符]</td>
	</tr>
    <tr>
	    <td>mediumint[3个字符]</td>
	</tr>
    <tr>
	    <td>int[4个字符]</td>
	</tr>
    <tr>
	    <td>bigint[8个字符]</td>
	</tr>
    <tr>
        <td rowspan="3">小数类型</td>
	    <td>float[单精度4个字节]</td>
	</tr>
     <tr>
	    <td>double[双精度8个字节]</td>
	</tr> 
    <tr>
	    <td>decimal[M,D][大小不确定]</td>
	</tr>
    <tr >
        <td rowspan="4"  colspan="2">文本类型(字符串类型)</td>
	    <td>char 0-255</td>
	</tr>
    <tr>
    	<td>varchar [0~2^16-1]</td>
    </tr>
    <tr>
    	<td>text 0~2^16-1</td>
    </tr>
    <tr>
    	<td>longtext 0~2^32-1</td>
    </tr>
    <tr >
        <td rowspan="2"  colspan="2">二进制数据类型</td>
	    <td>blob 0~2^16-1</td>
	</tr>
    <tr>
    	<td>longblob 0~2^32-1</td>
    </tr>
    <tr >
        <td rowspan="3"  colspan="2">日期类型</td>
	    <td>date [日期 年月日]</td>
	</tr>
    <tr>
    	<td>time [时间 时分秒]</td>
    </tr>
    <tr>
    	<td>datetime [年月日 时分秒 YYYY-MM-DD HH:mm:SS]</td>
    </tr>
</table>

> 定义一个无符号整数

```sql
CREATE table t1 (id tinyint);  -- 默认是有符号的
CREATE table t2 (id tinyint unsigned); -- 无符号的
```

> 创建BIT类型的字段

BIT(m) m 在 1-64

```sql
CREATE table t3 (id BIT(8));
```

添加数据按照给定的位数

比如  m = 8, 表示一个字节 0-255

```sql
INSERT INTO t3 VALUES(255);  -- OK

INSERT INTO t3 VALUES(256);  -- ERROR
```

显示按照 bit 

> 小数的基本使用

1. FLOAT/DOUBLE [UNSIGNED]  Float单精度精度，Double双精度

2. DECIMAL\[M,D][UNSIGNED]
   可以支持更加精确的小数位。M是小数位数（精度）的总数，D是小数点（标度）
   后面的位数。
   如果D是0，则值没有小数点或分数部分。M最大65。D最是30。

   如果D被省略，默认是0。

   如果M被省略，默认是10。
   建议：如果希望小数的精度高，推荐使用decimal

> 字符串的基本使用

1. CHAR(size)
   固定长度字符串最大255字符

2. VARCHAR(size)   0~65535
   可变长度字符串最大65532字节
   【utf8编码最大21844字符，1-3个字节用于记录大小】

细节

1. char(4)//这个4表示字符数（最大255），不是字节数，不管是中文还是字母都是放四个，按字符计算.
   varchar(4)//这个4表示字符数，不管是字母还是中文都以定义好的表的编码来存放数据

2. char(4)是定长（固定的大小），就是说，即使你插入'aa',也会占用分配的4个字符.
   varchar(4)是变长，就是说，如果你插入了'aa',实际占用空间大小并不是4个字符，而是按照实际占用空间来分配（varchar本身还需要占用1-3个字节来记录存放内容长度)

3. 什么时候使用char,什么时候使用varchar

   1. 如果数据是定长，推荐使用char,比如md5的密码，邮编，手机号，身份证号码等.char(32)

   2. 如果一个字段的长度是不确定，我们使用varchar,比如留言，文章

   查询速度 char > varchar

4. 在存放文本时，也可以使用Text数据类型.可以将TEXT列视为VARCHAR列，注意TeXt不能有默认值.大小0-2^16字节

   如果希望存放更多字符，可以选择MEDIUMTEXT0-2\^24或者LONGTEXT0~2^32

> 日期类型的基本使用

```sql
CREATE TABLE birthday(
t1 DATE,
t2 DATETIME,
t3 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP -- 存入当前时间
    ON UPDATE CURRENT_TIMESTAMP  -- 以当前时间更新
)
```

## CRUD

### 添加

```sql
INSERT INTO table_name (column1, column2, ...) VALUES (data1,data2, ...);
```

细节

1. 插入的数据应与字段的数据类型相同。
   比如把'abc'添加到int类型会错误

2. 数据的长度应在列的规定范围内，例如：不能将一个长度为80的字符串加入到长度为40的列中。

3. 在values中列出的数据位置必须与被加入的列的排列位置相对应。

4. 字符和日期型数据应包含在单引号中。

5. 列可以插入空值[前提是该字段允许为空]，insert into table value(null)

6. insert into tab_name (列名...) values (...), (...), (...), ...形式添加多条记录

7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称

8. 默认值的使用，当不给某个字段值时，如果有默认值就会添加，否则报错

### 修改

```sql
UPDATE table_name
SET col_name1=expr1 [,col_name2=expr2 [,col_name3=expr3 ...]]
[WHERE where_definition]
```

> 如果没有带 WHERE ，则会修改所有的

细节

1. UPDATE语法可以用新值更新原有表行中的各列。

2. SET子句指示要修改哪些列和要给予哪些值。

3. WHERE子句指定应更新哪些行。如没有WHERE子句，则更新所有的行。

4. 如果需要修改多个字段，可以通过set字段1=值1，字段2=值2…

### 删除

```sql
DELETE FROM table_name
[WHERE where_definition]
```

1. 如果不使用where子句，将删除表中所有数据。

2. Delete语句不能删除某一列的值（可使用update设为null或者"）

3. 使用delete语句仅删除记录，不删除表本身。如要删除表，使用drop table语句。

   ```sql
   drop table 表名;
   ```

### 查找

#### 基本用法

```sql
SELECT [DISTINCT] * | {column1, column2, column3 ..} FROM table_name;
```

注意事项

1. Select指定查询哪些列的数据。

2. column指定列名。

3. *号代表查询所有列。

4. From指定查询哪张表。

5. DISTINCT可选，指显示结果时，是否去掉重复数据 (要查询的字段全部相同时，才会去重)

> 表达式

```sql
SELECT * | {column1 | expression, column2 | expression, ...} FROM table_name;
```

> as

```sql
SELECT column_name as 别名 FROM table_name;
```

---

演示

```sql
CREATE TABLE `students`(
id INT NOT NULL,
`name` VARCHAR(10) NOT NULL,
chinese int NOT NULL DEFAULT 0,
english int NOT NULL DEFAULT 0,
math int NOT NULL DEFAULT 0);

INSERT INTO `students` (id, `name`, chinese,english,math) VALUES
(1,'刘备',89,78,90),
(2,'张飞',67,98,56),
(3,'宋江',87,78,77),
(4,'关羽',88,98,90),
(5,'赵云',82,84,67),
(6,'欧阳锋',55,85,45),
(7,'黄蓉',75,65,30);

SELECT `NAME`, (chinese+math+english) AS SCORE FROM STUDENTS; 
```

#### where语句

<table>
    <tr>
    	<td rowspan="5">比较运算符</td>
        <td>> < <= >= = <> !=</td>
        <td>大于、小于、大于等于、小于等于、不等于</td>
    </tr>
    <tr>
    	<td>BETWEEN ... AND ...</td>
        <td>显示在某一区间的值(闭区间)</td>
    </tr>
    <tr>
    	<td>IN(SET)</td>
        <td>显示在IN列表中的值，如IN(100,200)</td>
    </tr>
    <tr>
        <td>LINKE `赵%`<br/>NOT LIKE ``</td>
        <td>模糊查询</td>
    </tr>
    <tr>
    	<td>IS NULL</td>
        <td>判断是否为空</td>
    </tr>
    <tr>
        <td  rowspan="3">逻辑运算符</td>
    	<td>and</td>
        <td>多个条件同时成立</td>
    </tr>
    <tr>
    	<td>or</td>
        <td>多个条件任一成立</td>
    </tr>
    <tr>
    	<td>not</td>
        <td>不成立 如： WHERE NOT (SALARY > 100);</td>
    </tr> 
</table>

#### order by

```sql
SELECT column1，column2, column3 ...
FROM table_name
ORDER BY column asc | desc, ...;
```

细节

1. Order by指定排序的列，排序的列既可以是表中的列名，也可以是select语句后指定的列名。

2. Asc升序[默认]、Desc降序

3. ORDER BY子句应位于SELECT语句的结尾

---

演示

所有学生按成绩排名

```sql
SELECT NAME,(CHINESE + MATH +  ENGLISH) AS TOTAL_SCORE FROM STUDENTS
ORDER BY TOTAL_SCORE DESC;
```

## 函数

### 合计/统计函数 

#### COUNT

Count 返回行的总数

```sql
SELECT COUNT(*) | COUNT(column_name) FROM table_name 
[HWERE where_definition];
```

---

演示

统计数学大于90的学生人数

```sql
SELECT COUNT(*) FROM STUDENTS WHERE MATH > 90;
```

> count(*) 和 count(列) 的区别

count(*) 返回满足条件的记录的行数

count(列) 统计满足条件的列有多少个，但是会排除 null

#### SUM

Sum 函数返回满足 where 条件的行的和(一般使用在数值列)

```sql
SELECT SUN(列名) {,sum(列名)...} FROM table_name
[WHERE where_definition];
```

---

演示

统计总成绩

```sql
SELECT SUM(MATH) AS MATH_TOTAL, SUM(CHINESE) AS CHINESE_TOTAL,
SUM(ENGLISH) AS ENGLISH_TOTAL FROM STUDENTS;
```

> 注意

只对数值有作用，否则会报错

#### AVG

AVG 函数返回满足 where 条件的一列的平均值

```sql
SELECT AVG(列名) {，AVG(列名),...} FROM table_name
[WHERE where_definition];
```

---

演示

统计各科平均分

```SQL
SELECT AVG(MATH) AS AMTH_AVG, AVG(CHINESE) AS CHINESE_AVG, AVG(ENGLISH) AS ENGLISH_AVG FROM STUDENTS;
```

> 注意

只对数值有作用

#### MAX/MIN

MAX/MIN 函数返回满足 where 条件的一列的最大/最小值

---

演示

求班级最高分最低分

```SQL
SELECT MIN(CHINESE+MATH+ENGLISH) AS TOTAL_MIN
 MAX(CHINESE+MATH+ENGLISH) AS TOTAL_MAX FROM STUDENTS;
```

#### 分组统计

使用 group by 句对列进行分组

```sql
SELECT column1, column2, column3 .. FROM table_name GROUP BY column;
```

使用 having 子句对分组后的结果进行过滤

```sql
SELECT column1, column2, column3 .. FROM table_name GROUP BY column HAVING ..;
```

Group by用于对查询的结果分组统计
having子句用于限制分组显示结果(对统计的数据进一步筛选)

### 字符串函数

| 函数                                                         | 功能                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| <span style="color:red">CHARSET(str)</span>                  | 返回字符串字符集                                   |
| <span style="color:red">CONCAT (string2 [,...])</span>       | 连接字符串                                         |
| INSTR(string substring)                                      | 返回substring在string中出现的位置，没有返回0       |
| <span style="color:red">UCASE(string2)</span>                | 转换成大写                                         |
| <span style="color:red">LCASE(string2)</span>                | 转换成小写                                         |
| LEFT (string2,length)                                        | 从string2中的左边起取length个字符                  |
| <span style="color:red">LENGTH(string)</span>                | string长度[按照字节]                               |
| <span style="color:red">REPLACE (str,search_str,replace_str)</span> | 在str中用replace_str替换search_str                 |
| STRCMP(string1,string2)                                      | 逐字符比较两字串大小                               |
| <span style="color:red">SUBSTRING(str,position [,length])</span> | 从str的position开始【从1开始计算】，取length个字符 |
| LTRIM (string2 ) RTRIM (string2）TRIM(string2)               | 去除前端空格或后端空格或左右两边都去掉             |

### 数学函数

| 函数                                                         | 功能                             |
| ------------------------------------------------------------ | -------------------------------- |
| <span style="color:red">ABS(num)</span>                      | 绝对值                           |
| BIN (decimal_number)                                         | 十进制转二进制                   |
| <span style="color:red">CEILING(number2）</span>             | 向上取整，得到比num2大的最小整数 |
| CONV(number2,from_base,to_base)                              | 进制转换                         |
| <span style="color:red">FLOOR(number2)</span>                | 向下取整，得到比num2小的最大整数 |
| <span style="color:red">FORMAT (number,decimal_places)</span> | 保留小数位数                     |
| HEX(Decimal Number)                                          | 转十六进制                       |
| LEAST (number,number2 [,..])                                 | 求最小值                         |
| MOD (numerator,denominator)                                  | 求余                             |
| <span style="color:red">RAND([seed])</span>                  | RAND([seed])其范围为0<=v<=1.0    |

> RAND() 每次返回不同的随机数
>
> RAND(SEED) 返回随机数，如果SEED 不变，随机数也不变

### 时间日期函数

| 函数                                                         | 功能                                |
| ------------------------------------------------------------ | ----------------------------------- |
| <span style="color:red">CURRENT_DATE()</span>                | 当前日期                            |
| <span style="color:red">CURRENT_TIME ()</span>               | 当前时间                            |
| <span style="color:red">CURRENT_TIMESTAMP()</span>           | 当前时间戳                          |
| <span style="color:red">DATE(datetime)</span>                | 返回datetime的日期部分              |
| <span style="color:red">DATE_ADD(date2,INTERVAL d_value d_type)</span> | 在date2中加上日期或时间             |
| <span style="color:red">DATE_SUB (date2,INTERVAL d_value d_type)</span> | 在date2上减去一个时间               |
| <span style="color:red">DATEDIFF (date1,date2)</span>        | 两个日期差（结果是）                |
| TIMEDIFF(date1,date2)                                        | 两个时间差（多少小时多少分钟多少秒) |
| <span style="color:red">NOW ()</span>                        | 当前时间                            |
| YEAR\|Month\|DATE (datetime ) FROM_UNIXTIME()                | 年月日                              |

> FROM_UNIXSTAMP( )可以把一个 unix_timestamp 秒数(时间戳),转换成指定格式的日期
>
> %Y-%m-%d 格式是规定好的，表示年月日
>
> 意义: 在开发中，可以存放一个<b>整数</b>,然后表示时间，通过<b>FROM_UNIXTIME</b>转换

---

演示

查询在10分钟内发布的新闻

```sql
SELECT * FROM NEWS WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW();
```

### 加密和系统函数

| 函数                                                         | 功能                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <span style="color:red">USER()</span>                        | 查询用户                                                     |
| DATABASE()                                                   | 数据库名称                                                   |
| <span style="color:red">MD5(str)</span>                      | 为字符串算出一个MD5  32的字符串，（用户密码)加密             |
| PASSWORD(str)<br/><span style="color:#2d7ec7"><b>select from mysql.user \G</b></span> | 从原文密码str计算并返回密码字符串，通常用于对mysql数据库的<b>用户密码加密</b> |

### 流程控制函数

| 函数                                                         | 功能                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <span style="color:red">IF(expr1,expr2,expr3)</span> [三元表达式] | 如果expr1为True,则返回expr2否则返回expr3                     |
| IFNULL(expr1,expr2)  [短路运算符]                            | 如果expr1不为空NULL,则返回expr1,否则返回expr2                |
| <span style="color:red">SELECT CASE </span><span style="color:blue">WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 </span><span style="color:red">ELSE expr5</span> [多重] | 如果expr1为TRUE,则返回expr2,如果expr3为True,返国expr4,否则返会expr5 |

---

演示

如果 job 为 clerk 返回 职员

如果 job 为 manager 返回 经理

```sql
SELECT ENAME, (SELECT CASE 
WHEN JOB='CLERK' THEN '职员' 
WHEN JOB='MANAGER' THEN '经理' 
ELSE JOB END) AS JOB FROM EMP;
```

## 增强

1. 在MySQL中，日期类型可以直接比较，需要注意格式

   ```SQL
   SELECT * FROM emp WHERE birthday > '2022-06-02';
   ```

2. like 操作符

   1. %：表示0个或多个； 
   2. _：表示单个任意字符

3. 判断空值 <b>IS NULL</b>

4. ORDER BY 套娃

   ```sql
   SELECT * FROM students ORDER BY math desc, english asc;
   ```

5. 分页查询

   ```sql
   SELECT ... LIMIT start, rows 
   -- 从 start + 1行开始取
   -- 取出 rows 行
   -- start 从0开始计算
   ```

   推导公式

   ```sql
   SELECT * FROM table_name
   LIMIT 每页条数 * (当前页数-1),每页条数;
   ```

6. 顺序

   <span style="color:red">GROUP BY </span>,<span style="color:blue">HAVING</span>,<span style="color:red">ORDER BY</span>,<span style="color:blue">LIMIT</span>

   ```SQL
   SELECT column1,column2,column3..FROM table_name
               group by column
               having condition
               order by column
               limit start,rows;
   ```

## 多表查询

### 基本操作

```sql
SELECT a.column1,a.column2,...,b.column1,b.column2,...
FROM table_a AS a,table_b AS b,...
WHERE where_definition
[GROUP BY,[ORDER BY,[LIMIT]]];
```

> WHERE 条件至少要有 <b>表的数量-1</b>个

### 自连接

> 自连接是指在同一张表的连接(将同一张表看作两张表)。

```SQL
SELECT A.column1,B.column2
FROM table_name A,table_name B -- 取别名
WHERE where_definition;
```

取别名: 表名 表别名

### 子查询

子查询是指嵌入在其它sql语句中的select语句，也叫<b>嵌套查询</b>

#### 单行子查询
单行子查询是指只返回一行数据的子查询语句

```SQL
-- 返回和 SMITH 同一部门的员工
SELECT * 
FROM EMP
WHERE DEPTNO = (
	SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SMITH'
); 
```

#### 多行子查询
多行子查询指返回多行数据的子查询，使用<b>关键字in</b>

```sql
-- 查找10号部门有哪些工作
-- 返回做这些工作的员工信息，不包括10号部门
SELECT ENAME,JOB,SAL,DEPTNO
FROM EMP
WHERE JOB IN (
	SELECT DISTINCT JOB
    FROM EMP
    WHERE DEPTNO = 10
) AND DEPTNO <> 10;
```

#### 临时表

将子查询的结果当作临时表

```sql
-- 查询各部门工资最高的员工
-- 使用临时表
SELECT TEMP.EMPNO AS EMPNO,JOB,SAL,DEPTNO
FROM (
	SELECT MAX(SAL) AS MAX_SAL,EMPNO
    FROM EMP
    GROUP BY DEPTNO
) TEMP,EMP
WHERE TEMP.EMPNO = EMP.EMPNO;
```

#### ALL 和 ANY

```sql
-- 查询比所有30部门的员工工资都高的员工
-- 使用 ALL
SELECT ENAME,SAL
FROM EMP
WHERE SAL > ALL (
	SELECT SAL
    FROM EMP
    WHERE DEPTNO = 30
);
-- 等价于查询 MAX(SAL)
```

```sql
-- 查询比30部门一个员工工资高的员工
-- 使用 ANY
SELECT ENAME,SAL
FROM EMP
WHERE SAL > ANY(
	SELECT SAL
    FROM EMP
    WHERE DEPTNO = 30
);
-- 等价于查询MIN(SAL)
```

#### 多列子查询

各字段要对应

<span style="color:red">WHERE (column1, column2, ...) = (SELECT column1, column2, ...)</span>

```sql
-- 查询和 SMITH 部门和工作完全相同的员工（不包括 SMITH)
-- 多列子查询
SELECT ENAME,JOB,DEPTNO
FROM EMP
WHERE (JOB,DEPTNO) = (
		SELECT JOB,DEPTNO
        FROM EMP
        WHERE ENAME = 'SMITH'
        ) AND ENAME <> 'SMITH';
```

#### 表复制

> 复制到其他表

```sql
INSERT INTO tab_01
	(column1,column2, ...)
	SELECT column1,column2,... FROM tab_02;
```

> 自我复制

```sql
INSERT INTO tab_03
	SELECT * FROM tab_03;
```

### 表去重

1. 创建临时表

   ```mysql
   CREATE TABLE my_tmp LIKE my_tab;
   ```

2. 将表的数据通过 distinct 关键字处理，复制到 my_tmp;

   ```mysql
   INSERT INTO my_tmp
   		SELECT DISTINCT * FROM my_tab;
   ```

3. 清除 my_tab 的记录

   ```mysql
   DELETE FROM my_tab;
   ```

4. 复制 my_tmp 到 my_tab

   ```mysql
   INSERT INTO my_tab SELECT * FROM my_tep;
   ```

5. 删除 临时表

   ```mysql
   DROP TABLE my_tab;
   ```



---

### 合并查询

> 为了合并多个 select 语句的结果，可以使用集合操作符 <b>union</b>，<b>union all</b>

1. union all 

   获取两个结果集的并集，<b>不会取消重复行</b>

   ```mysql
   SELECT ename,sal,job from emp WHERE sal>2500 union all
   SELECT ename,sal,job from emp WHERE job="manager";
   ```

2. union 

   与 union all 相似，<b>会去重</b>



---

### 外连接

1. 左外连接
   (如果左侧的表完全显示我们就说是左外连接)

   ```mysql
   SELECT ... FROM 表1 LEFT JOIN 表2 ON 条件;
   ```

   表1 就是左表

2. 右外连接
   (如果右侧的表完全显示我们就说是右外连接)



演示

```mysql
CREATE TABLE stu(
	id int,
    `name` varchar(10)
);
    
INSERT INTO stu (id,`name`) VALUES (1,'Yae'), (2,'Ei'), (3,'Kokomi'), (4,'Ayaka');

CREATE TABLE exam (
	id int,
    grade int);
    
INSERT INTO exam VALUES(1,99), (2,60), (10,100);

SELECT id,`name`,grade FROM stu LEFT JOIN exam ON stu.id = exam.id;

select id,`name`,grade FROM stu RIGHT JOIN exam ON exam.id = stu.id;
```



### 约束

<b style="color:red">约束</b>用于确保数据库的数据满足特定的商业规则

### PRIMARY KEY （主键）

> 一行数据的唯一标识，<b style="color:red">定义后不能重复</b>

<b style="background-color:yellow">字段名 字段类型 PRIMARY KEY;</b>

```mysql
CREATE TABLE tab (
	id INT PRIMARY KEY,
    `name` VERCHAR(32),
    email VERCHAR(32)
);
```

主键不能重复，也<b>不能为 null</b>

```mysql
INSERT INTO tab VALUES (1,'Yae','yae@gmail.com');  -- ok

INSERT INTO tab VALUES (1,'Ei','ei@gmail.com');   -- 重复的主键
```

<b>复合主键</b>

```mysql
CREATE TABLE tab (
	id INT,
    `name` VERCHAR(32),
    email VERCHAR(32),
     PRIMARY KEY (id,`name`)
);
```

现在要 id 和 name 都相同才是相同的主键

```mysql
INSERT INTO tab VALUES (1,'Yae','yae@gmail.com');  -- ok

INSERT INTO tab VALUES (1,'Ei','ei@gmail.com');   -- ok 
```

> 1. primary key<b>不能重复而且不能为null</b>。
>
> 2. 一张表最多只能有一个主键，但可以是复合主键
>
> 3. 主键的指定方式有两种
>    - 直接在字段名后指定：字段名primakry key
>    - 在表定义最后写primary key(列名)：
>
> 4. 使用<b style="color:red">desc表名</b>，可以看到primary key的情况.



### NOT NULL （非空）

如果在列上定义了 not null ，name当插入数据时，必须为列提供数据

<b style="background-color:yellow">字段名 字段类型 <span style="color:red">not null</span></b>



### UNIQUE （唯一）

当定义了唯一约束后，该列的值不能重复

<b style="background-color:yellow">字段名 字段类型 <span style="color:red">unique</span></b>

```mysql
CREATE TABLE tab (
	id INT UNIQUE,
    `name` VERCHAR(32),
);
```

该列不能重复

```mysql
INSERT INTO tab VALUES (1,'Yae');  -- ok

INSERT INTO tab VALUES (1,'Ei');   -- 重复的
```

> 1. 如果没有指定 not null，则 unique 字段可以有多个 null
> 2. 一张表可以有多个 unique 字段



---

### FOREIGN KEY （外键）

用于定义主表和从表之间的关系：外键约束要定义在从表上，主表则必须具有主键约束或是unique约束，当定义外键约束后，要求外键列数据必须在主表的主键列存在或是为null

举例

地区表

| id   | country   | element |
| ---- | --------- | ------- |
| 1    | Mondstadt | Anemo   |
| 2    | Liyue     | Geo     |
| 3    | Inazuma   | Electro |

人物表

| id   | name   | country_id |
| ---- | ------ | ---------- |
| 001  | Klee   | 1          |
| 002  | Keqing | 2          |
| 003  | Kokomi | 3          |

可以将 地区表的id 作为主键，人物表 的 country_id 作为外键与之关联

<b style="background-color:yellow"><b style="color:red">FOREIGN KEY </b> (本表字段名) <span style="color:red"> REFERENCES </span> 主表名(主键名或unique字段名)</b>

```mysql
-- 主表
CREATE TABLE area (
	id INT PRIMARY KEY,
    country VERCHAR(32) NOT NULL DEFAULT '',
    element VERCHAR(32) NOT NULL DEFAULT ''
);

-- 从表
CREATE TABLE character(
	id INT PRIMARY KEY,
    `name` VERCHAR(32) NOT NULL DEFAULT '',
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES area (id)  -- 指定外键关系
)
```

细节

> 1. 外键指向的表的字段，要求是primary key或者是unique
>
> 2. 表的类型是innodb,这样的表才支持外键
>
> 3. 外键字段的类型要和主键字段的类型一致（长度可以不同）
>
> 4. 外键字段的值，必须在主键字段中出现过，或者为null(前提是外键字段允许为null)
>
> 5. 一旦建立主外键的关系，数据不能随意删除了

### CHECK

用于强制行数据必须满足的条件，假定在sa列上定义了check约束，并要求sa列值在1000\~2000之间，如果不再1000~2000之间就会提示出错。



### 自增长

使用 <b style="background-color:yellow">AUTO_INCREMENT</b>表示自增

```mysql
CREATE TABLE tab(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(10)
);
```

可以插入 null

```sql
INSERT INTO tab VALUES
(null,'Yae'),(null,'ei');
```

修改

```sql
ALTER TABLE tab
AUTO_INCREMENT = 100;
```



细节

> 1. 一股来说自增长是和primary key配合便用的
>
> 2. 自增长也可以单独使用[但是需要配合一个unique]
>
> 3. 自增长修饰的字段为<b>整数型</b>的（虽然小数也可以但是非常非常少这样使用)
>
> 4. 自增长默认从1开始，你也可以通过如下命令修改alter table 表名 auto_increment=xxx;
> 5. 如果有指定值，则以指定的值为准<b style="background-color:yellow">（如果指定了自增长，就要按自增长的规则）</b>





---

## 索引

### 索引的类型

1. 主键索引，主键自动的为主索引（类型Primary key)

2. 唯一索引(UNIQUE)
3. 普通索引(INDEX)

4. 全文索引(FULLTEXT[适用于MyISAM]
   开发中考虑使用：全文搜索Solr和ElasticSearch(ES)

### 索引使用

1. 添加索引

   ```sql
   CREATE [UNIQUE] INDEX index_name ON tbl_name (col_name [(length)] [ASC|DESC], ...);
   ```

   ```SQL
   ALTER TABLE tbl_name ADD INDEX [index_name] (index_col_name, ...);
   ```

2. 添加主键(索引)

   ```sql
   ALTER TABLE tbl_name ADD PRIMARY KEY (col_name,...);
   ```

3. 删除索引

   ```sql
   DROP INDEX index_name ON tbl_name;
   ```

   ```sql
   ALTER TABLE tbl_name DROP INDEX index_name;
   ```

4. 删除主键索引(比较特别)

   ```sql
   ALTER TABLE tbl_name DROP PRIMARY KEY;
   ```

5. 查询索引

   ```sql
   SHOW INDEX FROM tbl_name;
   
   SHOW INDEXES FROM tbl_name;
   
   SHOW KEYS FROM tbl_name;
   ```

   

### 规则

> 哪些列上适合使用索引

1. 较频繁的作为查询条件字段应该创建索引
2. 唯一性太差的字段不适合单独创建索引，即是频繁作为查询条件(如'man'，'woman')
3. 更新非常频繁的字段不适合创建索引
4. 不会出现在 WHERE 子句中的字段不该创建索引





## 事务

### 概念

- 什么是事务

  > 事务用于保证数据的一致性，它由<b style="background-color:yellow">一组相关的dml语句</b>组成，该组的dml语句要么全部成功，要么全部失败。如：转账就要用事务来处理，用以保证数据的一致性

- 事务和锁

  > 当执行事务操作时(dml语句)，mysql 会在表上加锁，防止其他用户改表的数据



### 操作

```sql
start transaction      -- 开始

savepoint 保存点名      -- 设置保存点

rollback to 保存点名    -- 回退事务

rollback               -- 回退全部事务

commit                 -- 提交事务，所有的操作生效，不能回退
```



细节

1. 如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚

2. 如果开始一个事务，你没有创建保存点.你可以执行rollback,默认就是回退到你事务开始的状态

3. 你也可以在这个事务中（还没有提交时），创建多个保存点。比如：

   savepoint  aaa;

   执行dml;

   savepoint bbb;

4. 你可以在事务没有提交前，选择回退到哪个保存点.

5. mysql的事务机制需要innodb的存储引擎，还可以使用，myisam不好使，

6. 开始一个事务start transaction set autocommit=off;



### 隔离级别

1. 多个连接开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性。（通俗解释）

2. 如果不考虑隔离性，可能会引发如下问题：
   - <b style="background-color:yellow">脏读(dirty read)</b>:当一个事务读取另一个事务尚未提交的修改时，产生脏读
   - <b style="background-color:yellow">不可重复读(nonrepeatable read)</b>:同一查询在同一事务中多次进行，由于其他提交事务所做的修改或删除，每次返回不同的结果集，此时发生不可重复读
   - <b style="background-color:yellow">幻读(phantom read)</b>:同一查询在同一事务中多次进行，由于其他提交事务所做的插入操作，每次返回不同的结果集，此时发生幻读。



| MySQL隔离级别                                          | 脏读 | 不可重复单独 | 幻读 | 加锁读                              |
| ------------------------------------------------------ | ---- | ------------ | ---- | ----------------------------------- |
| 读末提交(Read uncommited)                              | √    | √            | √    | 不加锁                              |
| <span style="color:red">读已提交(Read commited)</span> | ×    | √            | √    | 不加锁                              |
| 可重复读(Repeatable read)                              | ×    | ×            | ×    | 不加锁                              |
| <span style="color:red">可串行化(Serializable)</span>  | ×    | ×            | ×    | <span style="color:red">加锁</span> |



查看隔离级别

```sql
SELECT @@tx_isolation;   -- 当前会话

SELECT @@global.tx_isolation;   -- 系统当前隔离级别
```

设置隔离级别

```sql
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITED;  -- 当前会话

SET GLOBAL TRANSACTION ISOLATION LEVEL READ COMMITED;     -- 系统当前
```

默认的隔离级别 <b> repeatable read</b>，一般情况下，没有特殊要求，没必要修改

## 引擎

修改引擎

```SQL
ALTER TABLE `表名` ENGINE = 存储引擎;
```



## 视图

视图是一个<b style="background-color:yellow">虚拟表</b>,其内容由查询定义，同真实的表一样，视图包含列，其数据来自对应的真实表(基表)

### 基本使用

创建视图

```sql
CREATE VIEW view_name AS select语句;
```

修改视图

```sql
ALTER VIEW view_name AS select语句;   -- 更新成新的视图
```

显示视图结构

```sql
SHOW CREATE VIEW view_name;
```

删除视图

```sql
DROP VIEW view_name1,view_name2,...;
```



细节

1. 创建视图后，到数据库去看，对应视图只有一个视图结构文件
2. 视图的数据变化会影响到基表，基表的数据变化也会影响到视图
3. 视图中可以再使用视图，数据仍然来自基表

### 最佳实践

1. 安全。一些数据表有着重要的信息。有些字段是保密的，不能让用户直接看到。这时就可以创建一个视图，在这张视图中只保留一部分字段。这样，用户就可以查询自己需要的字段，不能查看保密的字段。

2. 性能。关系数据库的数据常常会分表存储，使用外键建立这些表的之间关系。这时，数据库查询通常会用到连接（JOIN)。这样做不但麻烦，效率相对也比较低。如果建立一个视图，将相关的表和字段组合在一起，就可以避免使用ON查询数据。

3. 灵活。如果系统中有一张旧的表，这张表由于设计的问题，即将被废弃。然而，很多应用都是基于这张表，不易修改。这时就可以建立一张视图，视图中的数据直接映射到新建的表。这样，就可以少做很多改动，也达到了升级数据表的目的。
