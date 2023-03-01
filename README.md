У приложения есть два класса для старта:

- Первый com.example.workingwhithfiles.cli. CLIDocumentParser → java console.
  При старте приложение ждет на вход строку с директорией. Для подсчета количества страниц в документах в структуре
  папок.
  Вывод:
  Documents: countDocument
  Pages: allPageInDir

- Второй com.example.workingwhithfiles WorkingWithFilesApplication. 
  При при старте поднимается Spring Boot.
  После чего открываем браузер и переходим по адресу localhost:8080/documents?path={path}.
  Path = путь до директории. 
  Получаем ответ в виде json {"Pages":365,"Documents":3}

В обработке документов была использована библиотека Aspose, подключена при помощи Maven. Все зависимости указаны в pom.xml.

