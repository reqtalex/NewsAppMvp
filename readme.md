# News App
Тестовое задание. Приложение-агрегатор свежих новостей из [newsapi.org](https://newsapi.org).
Приложение использует архитектурный паттерн представления MVP - ***Moxy***. Для внедрения зависимотей используется - ***dagger2***.
Главный экран новостей представляет собой пагинированный список с префетчингом пяти элементов - ***Jetpack Paging 3***, также предусмотено кэширование новостей в локальную базу данных - ***Room***.
В качестве клиента используется библиотека ***Retrofit***.
###Экран загрузки
![splah](https://sun9-26.userapi.com/impg/6GyN39sjtz01cZoObgqhFkU8MVjhLIOhCJp0ew/eBFxMfrj8Z8.jpg?size=486x1080&quality=96&sign=569f4b1d66f12a1bca77a74d18b3eb2a&type=album)
###Главный экран
![main](https://sun9-86.userapi.com/impg/UsmagFTbhFAPyhXp1wgeasXd4f1wYRCKJDfKmg/lF-W90rlnUI.jpg?size=486x1080&quality=96&sign=90ad4098c93bb2f43ed55011240a5416&type=album)
###Экран чтения
![read](https://sun9-26.userapi.com/impg/LCcOI6X4vfOSyC6iI-nRRVW2cWmto4aXujDEpA/DgNTcYGG64k.jpg?size=486x1080&quality=96&sign=8ce3742a02aaa82c0a06b21fbbfbcc66&type=album)
###Главный экран, если бд пуста и нет интернета
![main_error](https://sun9-40.userapi.com/impg/GYOcw6cIKXpbWR6bOYIwVONytHpTt_EMNmqcPA/p1DqhibHVMY.jpg?size=486x1080&quality=96&sign=f80ed7fb1973f0286131b5a305960284&type=album)
###Ошибка пагинации
![paging_error](https://sun9-67.userapi.com/impg/iLKCjkgq0WOey4Xo9CKx7RWUhtgzxduIzvhFOQ/fnfLIb67XdQ.jpg?size=486x1080&quality=96&sign=5d17da4f2f828503b9d0d3723cbfca9c&type=album)
Элементы указывающие на ошибку кликабельны и вызывают повторную попытку загрузки.
