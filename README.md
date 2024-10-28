### Сумма чисел

1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль. ✅

2. Примеры запуска программы:

    - `java Sum 1 2 3`

      Результат: 6

    - `java Sum 1 2 -3`

      Результат: 0

    - `java Sum "1 2 3"`

      Результат: 6

    - `java Sum "1 2" " 3"`

      Результат: 6

    - `java Sum " "`

      Результат: 0

   Аргументы могут содержать цифры и произвольные пробельные символы.

3. При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип `int`.

4. При выполнении задания полезно ознакомиться с документацией к классам [String](https://web.archive.org/web/20200223020936/https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) и [Integer](https://web.archive.org/web/20200223020936/https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html).

### Реверс

1. Разработайте класс `Reverse`, читающий числа из стандартного входа, и выводящий их на стандартный вывод в обратном порядке. ✅

2. В каждой строке входа содержится некоторое количество целых чисел (может быть 0). Числа разделены пробелами. Каждое число помещается в тип `int`.

3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке так же должен быть обратным к порядку чисел во входе.

4. Вход содержит не более 10^6 чисел.

5. Для чтения чисел используйте класс [Scanner](https://web.archive.org/web/20200223020936/https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html)

6. Примеры работы программы:

    - Вход:

      ```
      1 2
      3
      ```

      Выход:

      ```
      3
      2 1
      ```

    - Вход:

      ```
      1
      
      2 -3
      ```

      Выход:

      ```
      -3 2
      
      1
      ```


### Статистика слов

1. Разработайте класс `WordStat`, который будет подсчитывать статистику встречаемости слов во входном файле. ✅

2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.

3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входной файл.

4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.

5. Примеры работы программы:

    - Входной файл:

      ```
          To be, or not to be, that is the question:
      ```

      Выходной файл:

      ```
          to 2
          be 2
          or 1
          not 1
          that 1
          is 1
          the 1
          question 1
      ```

    - Входной файл:

      ```
          Monday's child is fair of face.
          Tuesday's child is full of grace.
      ```

      Выходной файл:

      ```
          monday's 1
          child 2
          is 2
          fair 1
          of 2
          face 1
          tuesday's 1
          full 1
          grace 1
      ```

    - Входной файл:

      ```
          Шалтай-Болтай
          Сидел на стене.
          Шалтай-Болтай
          Свалился во сне.
      ```

      Выходной файл:

      ```
          шалтай-болтай 2
          сидел 1
          на 1
          стене 1
          свалился 1
          во 1
          сне 1
      ```

### Свой сканер

1. Реализуйте свой аналог класса `Scanner` на основе `Reader`. ✅

2. Примените разработанный `Scanner` для решения задания «Реверс». ✅

3. Примените разработанный `Scanner` для решения задания «Статистика слов». ✅

4. Код, управляющий чтением, должен быть общим.

5. *Сложный вариант*. Код, выделяющий числа и слова, должен быть общим. ✅


### Статистика слов++

1. Разработайте класс `WordStatIndex`, который будет подсчитывать статистику встречаемости слов во входном файле. ✅

2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики слова приводятся к нижнему регистру.

3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.

4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.

5. Программа должна работать за линейное от размера входного файла время.

6. Для реализации программы используйте Collections Framework.

7. *Сложный вариант.* Реализуйте и примените класс `IntList`, компактно хранящий список целых чисел. ❌

8. Примеры работы программы:

    - Входной файл:

      ```
          To be, or not to be, that is the question:
      ```

      Выходной файл:

      ```
          to 2 1 5
          be 2 2 6
          or 1 3
          not 1 4
          that 1 7
          is 1 8
          the 1 9
          question 1 10
      ```

    - Входной файл:

      ```
          Monday's child is fair of face.
          Tuesday's child is full of grace.
      ```

      Выходной файл:

      ```
          monday's 1 1
          child 2 2 8
          is 2 3 9
          fair 1 4
          of 2 5 11
          face 1 6
          tuesday's 1 7
          full 1 10
          grace 1 12
      ```

    - Входной файл:

      ```
          Шалтай-Болтай
          Сидел на стене.
          Шалтай-Болтай
          Свалился во сне.
      ```

      Выходной файл:

      ```
          шалтай-болтай 2 1 5
          сидел 1 2
          на 1 3
          стене 1 4
          свалился 1 6
          во 1 7
          сне 1 8
      ```


### Разметка

1. Разработайте набор классов для текстовой разметки. ✅

2. Класс `Paragraph` может содержать произвольное число других элементов разметки и текстовых элементов.

3. Класс `Text` – текстовый элемент.

4. Классы разметки `Emphasis`, `Strong`, `Strikeout` – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.

5. Все классы должны реализовывать метод `toMarkdown`, который должен генерировать Markdown-разметку по следующим правилам:

    1. текстовые элементы выводятся как есть;
    2. выделенный текст окружается символами '`*`';
    3. сильно выделенный текст окружается символами '`__`';
    4. зачеркнутый текст окружается символами '`~`'.

6. Следующий код должен успешно компилироваться:
    ```
   Paragraph paragraph = new Paragraph(List.of(
       new Strong(List.of(
           new Text("1"),
           new Strikeout(List.of(
               new Text("2"),
               new Emphasis(List.of(
                   new Text("3"),
                   new Text("4")
               )),
               new Text("5")
           )),
           new Text("6")
       ))
   ));
    ```

### Markdown to HTML

1. Разработайте конвертер из Markdown-разметки в HTML. ✅

2. Конвертер должен поддерживать следующие возможности:

    1. Абзацы текста разделяются пустыми строками.
    2. Элементы строчной разметки: выделение (`*` или `_`), сильное выделение (`**` или `__`), зачеркивание (`--`), код (```)
    3. Заголовки (`#` * уровень заголовка)

3. Конвертер должен называться `Md2Html` и принимать два аргумента: название входного файла с Markdown-разметкой и название выходного файла с HTML-разметкой. Оба файла должны иметь кодировку UTF-8.

4. Пример

    - Входной файл

      ```
      # Заголовок первого уровня
      
      ## Второго
      
      ### Третьего ## уровня
      
      #### Четвертого
      # Все еще четвертого
      
      Этот абзац текста,
      содержит две строки.
      
          # Может показаться, что это заголовок.
      Но нет, это абзац начинающийся с `#`.
      
      #И это не заголовок.
      
      ###### Заголовки могут быть многострочными
      (и с пропуском заголовков предыдущих уровней)
      
      Мы все любим *выделять* текст _разными_ способами.
      **Сильное выделение**, используется гораздо реже,
      но __почему бы и нет__?
      Немного --зачеркивания-- еще ни кому не вредило.
      Код представляется элементом `code`.
      
      Обратите внимание, как экранируются специальные
      HTML-символы, такие как `<`, `>` и `&`.
      
      Знаете ли вы, что в Markdown, одиночные * и _
      не означают выделение?
      Они так же могут быть заэкранированы
      при помощи обратного слэша: \*.
      
      
      
      Лишние пустые строки должны игнорироваться.
      
      Любите ли вы *вложеные __выделения__* так,
      как __--люблю--__ их я?
                  
      ```

    - Выходной файл

      ```
      <h1>Заголовок первого уровня</h1>
      <h2>Второго</h2>
      <h3>Третьего ## уровня</h3>
      <h4>Четвертого
      # Все еще четвертого</h4>
      <p>Этот абзац текста,
      содержит две строки.</p>
      <p>    # Может показаться, что это заголовок.
      Но нет, это абзац начинающийся с <code>#</code>.</p>
      <p>#И это не заголовок.</p>
      <h6>Заголовки могут быть многострочными
      (и с пропуском заголовков предыдущих уровней)</h6>
      <p>Мы все любим <em>выделять</em> текст <em>разными</em> способами.
      <strong>Сильное выделение</strong>, используется гораздо реже,
      но <strong>почему бы и нет</strong>?
      Немного <s>зачеркивания</s> еще ни кому не вредило.
      Код представляется элементом <code>code</code>.</p>
      <p>Обратите внимание, как экранируются специальные
      HTML-символы, такие как <code>&lt;</code>, <code>&gt;</code> и <code>&amp;</code>.</p>
      <p>Знаете ли вы, что в Markdown, одиночные * и _
      не означают выделение?
      Они так же могут быть заэкранированы
      при помощи обратного слэша: *.</p>
      <p>Лишние пустые строки должны игнорироваться.</p>
      <p>Любите ли вы <em>вложеные <strong>выделения</strong></em> так,
      как <strong><s>люблю</s></strong> их я?</p>
                  
      ```




### Выражения

1. Разработайте классы `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` для вычисления выражений с одной переменной. ✅

2. Классы должны позволять составлять выражения вида

```
new Subtract( new Multiply( new Const(2), new Variable("x") ), new Const(3) ).evaluate(5)
```

При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу `evaluate` (на данном этапе имена переменных игнорируются). Таким образом, результатом вычисления приведенного примера должно стать число 7.

3. Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например

```
new Subtract( new Multiply( new Const(2), new Variable("x") ), new Const(3) ).toString()
```
должен выдавать `((2 * x) - 3)`.

4. Реализуйте метод `equals`, проверяющий, что два выражения совпадают. Например,
```
new Multiply(new Const(2), new Variable("x")) .equals(new Multiply(new Const(2), new Variable("x")))
```

должно выдавать `true`, а

```
new Multiply(new Const(2), new Variable("x")) .equals(new Multiply(new Variable("x"), new Const(2)))
```
должно выдавать `false`. ✅

5. Для тестирования программы должен быть создан класс `Main`, который вычисляет значение выражения `x2−2x+1`, для `x`, заданного в командной строке.

6. При выполнении задания следует обратить внимание на:
- Выделение общего интерфейса создаваемых классов.
- Выделение абстрактного базового класса для бинарных операций.
-

###  Разбор выражений

1. Доработайте предыдущее домашнее задание, так что бы выражение строилось по записи вида

`x * (x - 2) * x + 1` ✅

2. В записи выражения могут встречаться: умножение `*`, деление `/`, сложение `+`, вычитание `-`, унарный минус `-`, целочисленные константы (в десятичной системе счисления, которые помещаются в 32-битный знаковый целочисленный тип), круглые скобки, переменные (`x`) и произвольное число пробельных символов в любом месте (но не внутри констант).

3. Приоритет операторов, начиная с наивысшего

1. унарный минус;
2. умножение и деление;
3. сложение и вычитание.

4. Разбор выражений рекомендуется производить [методом рекурсивного спуска](https://web.archive.org/web/20200223020936/https://ru.wikibooks.org/wiki/Реализации_алгоритмов/Метод_рекурсивного_спуска). Алгоритм должен работать за линейное время.

### Обработка ошибок

1. Добавьте в программу, вычисляющую выражения, обработку ошибок, в том числе:
    - ошибки разбора выражений; ✅
    - ошибки вычисления выражений. ✅

2. При выполнении задания следует обратить внимание на дизайн и обработку исключений.

3. Человеко-читаемые сообщения об ошибках должны выводиться на консоль.

4. Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными).