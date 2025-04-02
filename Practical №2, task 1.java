class Author {
    private String name;
    private String email;
    private char gender;

    // Конструктор
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    // Сеттер для email
    public void setEmail(String email) {
        this.email = email;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Автор: " + name + " (" + gender + "), Email: " + email;
    }
}

// Класс для тестирования Author
// Объявление публичного класса
public class TestAuthor {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создание объекта Author
        Author author = new Author("Дж. К. Роулинг", "rowling@email.com", 'F');
        
        // Вывод информации об авторе
        System.out.println(author);
        
        // Изменение email
        author.setEmail("new_email@email.com");
        System.out.println("После изменения email: " + author);
    }
}
