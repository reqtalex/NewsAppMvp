# News App
Тестовое задание. Приложение-агрегатор свежих новостей из [newsapi.org](https://newsapi.org).
Приложение использует архитектурный паттерн представления MVP - ***Moxy***. Для внедрения зависимотей используется - ***dagger2***.
Главный экран новостей представляет собой пагинированный список с префетчингом пяти элементов - ***Jetpack Paging 3***, также предусмотено кэширование новостей в локальную базу данных - ***Room***.
В качестве клиента используется библиотека ***Retrofit***.

### Экран загрузки
![splah](https://sun9-59.userapi.com/impg/h0hWHWWRUZ0Lit6RTWaBY6M5FwtAt2o60Lac0Q/tEgWy0NQLJk.jpg?size=288x640&quality=96&sign=934b2a259cee50a717ea6ba0cd6ba8cf&type=album)
### Главный экран
![main](https://sun9-34.userapi.com/impg/LK3sGUSf3_TAoOaHTFwGJYfPxSsxSbzikp8ZpQ/b04e5Z7XoLw.jpg?size=288x640&quality=96&sign=b2890228b14e4dfdf1117346e968efae&type=album)
### Экран чтения
![read](https://sun9-62.userapi.com/impg/1C-C3x58q3fIDgnVfij-rqYmB19RhuJkTulJZw/3tuWAEnTFA8.jpg?size=288x640&quality=96&sign=3c0c0b271f1389d2e9469ce964ddf620&type=album)
### Главный экран, если бд пуста и нет интернета
![main_error](https://sun9-6.userapi.com/impg/7EMp4_3d5Nx4Iq6kuD9tjc1iBmIYhvb6sNRRQw/itOKRlCDtHE.jpg?size=288x640&quality=96&sign=07ecd3768e75304a28cd1b68f19cf512&type=album)
### Ошибка пагинации
![paging_error](https://vk.com/im?peers=c307_139459375_128006571&sel=98059751&z=photo98059751_457247869%2Fmail2483793) </br>
Элементы указывающие на ошибку кликабельны и вызывают повторную попытку загрузки.
