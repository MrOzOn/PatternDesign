# [Адаптер (Adapter)](./adapter/main.kt)

Это структурный паттерн проектирования, который позволяет объектам с несовместимыми интерфейсами работать вместе. Преобразует интерфейс одного класса в другой интерфейс, на который рассчитаны клиенты.

Адаптеры могут не только переводить данные из одного формата в другой, но и помогать объектам с разными интерфейсами работать сообща. Иногда возможно создать даже _двухсторонний_ адаптер, который работал бы в обе стороны.

**Адаптер объектов**
Эта реализация использует агрегацию: объект адаптера «оборачивает», то есть содержит ссылку на служебный объект. Такой подход работает во всех языках программирования.

**Адаптер классов**
Эта реализация базируется на наследовании: адаптер наследует оба интерфейса одновременно. Такой подход возможен только в языках, поддерживающих множественное наследование, например, C++.

## Другое название
Обертка (Wrapper)

## Применимость

- вы хотите использовать существующий класс, но его интерфейс не соответствует вашим потребностям
- требуется создать повторно используемый класс, который должен взаимодействовать с заранее неизвестными или не связанными с ним классами, имеющими несовместимые интерфейсы
- (**_только для адаптера объектов!_**) нужно использовать несколько существующих подклассов, но непрактично адаптировать их интерфейсы путем порождения новых подклассов от каждого. В этом случае адаптер объектов может приспосабливать интерфейс их общего родительского класса

## Отношения

Клиенты вызывают операции экземпляра адаптера Adapter. В свою очередь адаптер вызывает операции адаптируемого объекта или класса Adaptee, который и выполняет запрос.

## Результаты

Адаптеры объектов и классов обладают разными достоинствами и недостатками.

**Адаптер объектов**
- позволяет одному адаптеру (Adapter) работать со многим адаптируемыми объектами (Adaptee), то есть с самим Adaptee и его подклассами (если таковые имеются). Адаптер может добавить новую функциональность сразу всем адаптируемым объектам
- затрудняет замещение операций класса Adaptee. Для этого потребуется породить от Adaptee подкласс и заставить Adapter ссылаться на этот подкласс, а не на сам Adaptee

**Адаптер классов**
- адаптирует адаптируемый класс (Adaptee) к целе (Target), перепоручая действия конкретному классу Adaptee. Поэтому данный паттерн не будет работать, если мы захотим одновременно адаптировать класс и его подклассы
- позволяет адаптеру (Adapter) заместить некоторые операции адаптируемого класса Adaptee, так как Adapter есть не что иное, как подкласс Adaptee
- вводит только один новый объект. Чтобы добраться до адаптируемого класса, не нужно никакого дополнительного обращения по указателю

# [Мост (Bridge)](./bridge/main.kt)

Это структурный паттерн проектирования, который разделяет один или несколько классов на две отдельные иерархии — абстракцию и реализацию, позволяя изменять их независимо друг от друга.

## Другое название
Описатель/Тело (Handle/Body)

## Применимость

- требуется избежать постоянной привязки абстракции к реализации
- и абстракции, и реализации должны расширяться новыми подклассами
- изменения в реализации абстракции не должны отражаться на клиентах
- число классов стремительно разрастается

## Отношения

Объект абстракции перенаправляет запросы клиента своему объекту реализации.

## Результаты

- отделение реализации от интерфейса
- повышение степени расширяемости
- сокрытие деталей реализации от клиентов

# [Компоновщик (Composite)](./composite/main.kt)

Это структурный паттерн проектирования, который позволяет сгруппировать множество объектов в древовидную структуру, а затем работать с ней так, как будто это единичный объект.

## Применимость

- требуется представить иерархию объектов вида «часть — целое»
- клиенты должны по единым правилам работать с составными и индивидуальными объектами

## Отношения

Клиенты используют интерфейс класса Graphic для взаимодействия с объектами в составной структуре. Если получателем запроса является листовый объект (Dot, Circle), то он и обрабатывает запрос. Когда же получателем является составной объект CompoundGraphic, то обычно он перенаправляет запрос своим потомкам — возможно, с выполнением некоторых дополнительных операций до или после перенаправления.

## Результаты

- определяет иерархии классов, состоящие из примитивных и составных объектов
- упрощает архитектуру клиента
- облегчает добавление новых видов компонентов. Новые подклассы классов CompoundGraphic или Dot, Circle будут автоматически работать с уже существующими структурами и клиентским кодом.
- способствует созданию общего дизайна

**_Важно_**

Иногда бывает нужно, чтобы составной объект мог включать только определенные виды компонентов. Паттерн компоновщик не позволяет воспользоваться для реализации таких ограничений статической системой типов. Вместо этого приходится проводить проверки во время выполнения.

# [Декоратор (Decorator)](./decorator/main.kt)

Это структурный паттерн проектирования, который позволяет динамически добавлять объектам новую функциональность, оборачивая их в полезные «обёртки».
Является гибкой альтернативой порождению подклассов с целью расширения функциональности.

## Применимость

- динамическое, прозрачное для клиентов добавление обязанностей объектам (не затрагивающее другие объекты)
- реализация обязанностей, которые могут быть сняты с объекта
- расширение путем порождения подклассов по каким-то причинам неудобно или невозможно. Иногда приходится реализовывать много независимых расширений, так что порождение подклассов для поддержки всех возможных комбинаций приведет к стремительному росту их числа. В других случаях определение класса может быть скрыто или почему-либо еще недоступно, так что породить от него подкласс нельзя.

## Отношения

Decorator переадресует запросы объекту Component. Может выполнять и дополнительные операции до и после переадресации.

## Результаты

У паттерна декоратор есть, по крайней мере, два плюса и два минуса

_+_
- большая гибкость, нежели у статического наследования
- позволяет избежать перегруженных функциями классов на верхних уровнях иерархии

_-_
- декоратор и его компонент не идентичны. Декоратор действует как прозрачное обрамление. Но декорированный компонент все же не идентичен исходному.
- множество мелких объектов. При использовании в проекте этого паттерна нередко формируется система, составленная из большого числа мелких объектов, похожих друг на друга. Такие объекты различаются только способом взаимосвязи, а не классом и не значениями своих внутренних переменных. Хотя такие системы легко настраиваются проектировщиком, хорошо разбирающимся в их строении, изучать и отлаживать их очень тяжело.

# [Фасад (Facade)](./facade/main.kt)

Это структурный паттерн проектирования, который предоставляет простой интерфейс к сложной системе классов, библиотеке или фреймворку.

Предоставляет унифицированный интерфейс вместо набора интерфейсов некоторой подсистемы. _Фасад_ определяет интерфейс более высокого уровня, который упрощает использование подсистемы.

## Применимость

- предоставление простого интерфейса к сложной подсистеме
- многочисленные зависимости между клиентами и классами реализации абстракции
- требуется разложить подсистему на отдельные уровни

## Отношения

Клиенты общаются с подсистемой, посылая запросы фасаду. Он переадресует их подходящим объектам внутри подсистемы. Хотя основную работу выполняют именно объекты подсистемы, фасаду, возможно, придется преобразовать свой интерфейс в интерфейсы подсистемы.

## Результаты

- он изолирует клиентов от компонентов подсистемы, уменьшая тем самым число объектов, с которыми клиентам приходится иметь дело, и упрощая работу с подсистемой
- позволяет ослабить связанность между подсистемой и ее клиентами. Зачастую компоненты подсистемы сильно связаны. Слабая связанность позволяет видоизменять компоненты, не затрагивая при этом клиентов
- фасад не препятствует приложениям напрямую обращаться к классам подсистемы, если это необходимо. Таким образом, у вас есть выбор между простотой и общностью.

# [Приспособленец (Flyweight)](./flyweight/main.kt)

Это структурный паттерн проектирования, который позволяет вместить бóльшее количество объектов в отведённую оперативную память.
Применяет совместное использование для эффективной поддержки множества мелких объектов.

## Другое название
Легковес (Flyweight)

## Применимость

Применяйте этот паттерн, когда выполнены все нижеперечисленные условия:

- в приложении используется большое число объектов
- из-за этого затраты на хранение высоки
- большую часть состояния объектов можно вынести вовне
- многие группы объектов можно заменить относительно небольшим количеством совместно используемых объектов, поскольку внешнее состояние вынесено
- приложение не зависит от идентичности объекта. Поскольку объекты-приспособленцы могут использоваться совместно, то проверка на идентичность возвратит признак истинности для концептуально различных объектов

## Отношения

- состояние, необходимое приспособленцу для нормальной работы, классифицируется на внутреннее или внешнее. Внутреннее состояние хранится в самом объекте ConcreteFlyweight. Внешнее состояние хранится или вычисляется клиентами. Клиент передает его приспособленцу при вызове операций
- клиенты не должны создавать экземпляры класса TreeType напрямую, а могут получать их только от объекта TreeFactory. Это позволит гарантировать корректное совместное использование.

## Результаты

При использовании приспособленцев возможны затраты на передачу, поиск или вычисление внутреннего состояния на стадии выполнения, особенно если раньше оно хранилось как внутреннее. Однако такие затраты с лихвой компенсируются экономией памяти за счет совместного использования объектов-приспособленцев.

# [Заместитель (Proxy)](./proxy/main.kt)

Это структурный паттерн проектирования, который позволяет подставлять вместо реальных объектов специальные объекты-заменители. Эти объекты перехватывают вызовы к оригинальному объекту, позволяя сделать что-то до или после передачи вызова оригиналу.
Является суррогатом другого объекта и контролирует доступ к нему.

## Другое название
Cуррогат (Surrogate)

## Применимость

Паттерн _заместитель_ применим во всех случаях, когда возникает необходимость сослаться на объект более гибким или нетривиальным способом, чем при использовании простого указателя.
В частности:
- виртуальный заместитель создает «тяжелые» объекты по требованию
- защищающий заместитель контролирует доступ к исходному объекту
- «умная» ссылка — это замена обычного указателя. Она позволяет выполнить дополнительные действия при доступе к объекту.
- загрузку объекта из долгосрочного хранилища в память при первом обращении к нему
- проверку и установку блокировки на реальный объект при обращении к нему, чтобы никакой другой объект не смог в это время изменить его

## Отношения

Заместитель при необходимости переадресует запросы объекту. Детали зависят от вида заместителя.

## Результаты

С помощью паттерна заместитель при доступе к объекту вводится дополнительный уровень косвенности. У этого подхода есть много вариантов в зависимости от вида заместителя:
- удаленный заместитель может скрыть тот факт, что объект находится в другом адресном пространстве
- виртуальный заместитель может выполнять оптимизацию, например создание объекта по требованию
- защищающий заместитель и «умная» ссылка позволяют решать допол- нительные задачи при доступе к объекту

