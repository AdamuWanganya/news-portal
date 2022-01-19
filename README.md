# Portal News

This is a java website that allows user to be added on department,view news related to deparments.

## Live link




## Technologies Used

- Java
- Gradle
- Spark Framework
- JUnit
- Heroku
- psql
- postman

## Setup Requirements for database
- create db by runing psql < create.sql on terminal or create manually by:

- CREATE DATABASE portal_news;

- \c portal_news

- CREATE TABLE departments (id SERIAL PRIMARY KEY, name varchar, description varchar);

- CREATE TABLE users (id SERIAL PRIMARY KEY, name varchar, position varchar, yearsActive int, departmentId int);

- CREATE TABLE news (id SERIAL PRIMARY KEY, name varchar, content varchar, departmentId int);

- CREATE TABLE departments_news (id SERIAL PRIMARY KEY, departmentId int, newsId int);

- CREATE TABLE departments_users (id SERIAL PRIMARY KEY, departmentId int, userId int);

- CREATE DATABASE portal_news_test WITH TEMPLATE portal_news;
- Go to DB.class in main/java folder and make necessary changes
- Go to DatabaseRule in test/java folder and make necessary changes

## Setup Installations Requirements
* To run the application, in your terminal:

    1. Clone or download the Repository
    2. cd into directory then run `cd PortalNews`
    3. Rebuild the Project Using Intellij IDEA or ...
    4. Open terminal command line then navigate to the root folder of the application.
    5. Run `gradle run` command.
    6. Navigate to `http://localhost:4567/` in your browser.

## Author
- Adamu Wanganya email:wanganyaadamu@gmail.com
### Development

Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## Known Bugs

If you find a bug (the website couldn't handle the query and / or gave undesired results), kindly open an issue [here](https://github.com/AdamuWanganya/news-portal/issues/new) by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue [here](https://github.com/AdamuWanganya/news-portal/issues/new). Please include sample queries and their corresponding results.

### License

*MIT*
Copyright (c) 2022 **Adamu Wanganya**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.