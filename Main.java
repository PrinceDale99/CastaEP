import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Main() {
        setTitle("The Ahrke E-Portfolio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create header
        JPanel header = new JPanel();
header.setBackground(new Color(35, 39, 42));
header.setLayout(new FlowLayout());
// Create the JLabel with light blue color
JLabel headerLabel = new JLabel("The Ahrke E-Portfolio");
headerLabel.setForeground(new Color(173, 216, 230)); // Light blue color
header.add(headerLabel);
header.setPreferredSize(new Dimension(800, 50));

        // Create sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(0, 1));
        sidebar.setBackground(new Color(44, 47, 51));
        sidebar.setPreferredSize(new Dimension(200, 600));

        // Add sections to the sidebar
        String[] sections = {"Home", "About", "Projects", "Contact", "Our Knowledge"};
        for (String section : sections) {
            JButton button = new JButton(section);
            button.setBackground(new Color(44, 47, 51));
            button.setForeground(new Color(153, 170, 181));
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.addActionListener(new SectionButtonListener());
            addHoverEffect(button);  // Add hover effect

            sidebar.add(button);
        }

        // Create main content panel with card layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panels wrapped in JScrollPane for vertical scrolling
        mainPanel.add(new JScrollPane(createHomePanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), "Home");
        mainPanel.add(new JScrollPane(createAboutPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), "About");
        mainPanel.add(new JScrollPane(createProjectsPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), "Projects");
        mainPanel.add(new JScrollPane(createContactPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), "Contact");
        mainPanel.add(new JScrollPane(createKnowledgePanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), "Our Knowledge");

        // Create main layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(header, BorderLayout.NORTH);
        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(173, 216, 230)); // Light blue background
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(44, 47, 51)); // Original background
            }
        });
    }

    // Helper method to create a panel with rounded corners, padding, and margin
    private JPanel createTextBox(String content) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(35, 39, 42));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);  // Rounded edges
            }
        };

        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);  // Make panel transparent for rounded edges effect
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));  // Padding

        JTextArea textArea = new JTextArea(content);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(35, 39, 42));
        textArea.setForeground(Color.WHITE);

        panel.add(textArea, BorderLayout.CENTER);
        return panel;
    }

    // Creating the Home section
    private JPanel createHomePanel() {
    JPanel homePanel = new JPanel();
    homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
    homePanel.setBackground(new Color(44, 47, 51));

    JLabel title = new JLabel("Welcome to Our E-Portfolio");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(Color.WHITE);
    title.setAlignmentX(Component.CENTER_ALIGNMENT);

    String content = "Welcome to My E-Portfolio!\n\n" +
            "I’m excited to share my journey, accomplishments, and projects through this E-Portfolio. " +
            "This space is dedicated to showcasing my professional and personal growth, giving you a glimpse " +
            "into my skills, experience, and achievements.\n\n" +
            "This project was created as a requirement for my Computer Programming class, allowing me to apply " +
            "my programming skills in a practical way. It highlights the knowledge I've gained and serves as a " +
            "platform to reflect on my learning journey.\n\n" +
            "By exploring my E-Portfolio, you'll find detailed information about the projects I've worked on, " +
            "the skills I've developed, and how I can contribute to potential opportunities. I hope it inspires you " +
            "and provides a better understanding of my capabilities!\n";

    homePanel.add(title);
    homePanel.add(Box.createRigidArea(new Dimension(0, 20)));
    homePanel.add(createTextBox(content));

    return homePanel;
}

    // Creating the About Us section
    private JPanel createAboutPanel() {
    JPanel aboutPanel = new JPanel();
    aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
    aboutPanel.setBackground(new Color(44, 47, 51));

    JLabel title = new JLabel("About Us");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(Color.WHITE);

    // About text content
    String content = "Hey, curious about us?\n\n"
            + "Welcome to Ahrke! We're stoked you're interested in learning more.\n"
            + "We're a young company with bold ambitions, driven by creativity and passion. "
            + "Our journey's just beginning, and we're excited to see where it takes us!\n\n"
            + "We're all about:\n"
            + "- Crafting solutions that inspire\n"
            + "- Building meaningful connections\n"
            + "- Having fun along the way\n\n"
            + "Want to join the adventure? Explore our site, say hi, or collaborate with us!\n\n"
            + "Cheers,\nThe Ahrke Team";

    aboutPanel.add(title);
    aboutPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    aboutPanel.add(createTextBox(content));

    // Adding two owner boxes
    aboutPanel.add(createOwnerBox("Yisrael Wyatt Castañares", "Grade 12 Student", 
        "Wyatt is passionate about innovation and loves bringing creative ideas to life.", 
        "casta.jpg"));
    aboutPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing between boxes

    aboutPanel.add(createOwnerBox("Name", "Grade 12 Student", 
        "??? is a tech enthusiast with a vision to revolutionize the digital world.", 
        "placeholder.png"));

    return aboutPanel;
}

private JPanel createOwnerBox(String name, String title, String description, String imagePath) {
    JPanel ownerBox = new JPanel();
    ownerBox.setLayout(new BoxLayout(ownerBox, BoxLayout.Y_AXIS));
    ownerBox.setBackground(new Color(60, 63, 65));
    ownerBox.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding
    ownerBox.setPreferredSize(new Dimension(400, 200));
    ownerBox.setMaximumSize(new Dimension(500, 250)); // Ensuring max size
    ownerBox.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    // Adding rounded corners
    ownerBox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.DARK_GRAY),
        BorderFactory.createEmptyBorder(15, 15, 15, 15)));

    // Adding Image at the top
    JLabel imageLabel = new JLabel(new ImageIcon(imagePath)); // Use an actual image path
    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Adding Name
    JLabel nameLabel = new JLabel(name);
    nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
    nameLabel.setForeground(Color.WHITE);
    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Adding Title
    JLabel titleLabel = new JLabel(title);
    titleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
    titleLabel.setForeground(Color.LIGHT_GRAY);
    titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Adding Description
    JTextArea descriptionArea = new JTextArea(description);
    descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
    descriptionArea.setForeground(Color.WHITE);
    descriptionArea.setBackground(new Color(60, 63, 65));
    descriptionArea.setLineWrap(true);
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setEditable(false);
    descriptionArea.setMaximumSize(new Dimension(400, 100));
    descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Add top margin

    // Adding components in order: Image -> Name -> Title -> Description
    ownerBox.add(imageLabel);
    ownerBox.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
    ownerBox.add(nameLabel);
    ownerBox.add(Box.createRigidArea(new Dimension(0, 5))); // Spacing
    ownerBox.add(titleLabel);
    ownerBox.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
    ownerBox.add(descriptionArea);

    return ownerBox;
}

    // Creating the Projects section
    // Method to create a project section
private JPanel createProject(String titleText, String descriptionText, String codeText, String outputText) {
    JPanel projectPanel = new JPanel();
    projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.Y_AXIS));
    projectPanel.setBackground(new Color(44, 47, 51));

    // Project title
    JLabel projectTitle = new JLabel(titleText);
    projectTitle.setFont(new Font("Arial", Font.BOLD, 18));
    projectTitle.setForeground(Color.WHITE);

    // Project description
    JLabel projectDescription = new JLabel(descriptionText);
    projectDescription.setFont(new Font("Arial", Font.PLAIN, 14));
    projectDescription.setForeground(Color.LIGHT_GRAY);

    // Code box (JTextArea) for the project
    JTextArea codeArea = new JTextArea(10, 40);
    codeArea.setFont(new Font("Courier New", Font.PLAIN, 14));
    codeArea.setText(codeText);
    codeArea.setForeground(Color.WHITE);
    codeArea.setBackground(new Color(36, 36, 36));
    codeArea.setEditable(false); // Make it non-editable
    codeArea.setLineWrap(true);
    codeArea.setWrapStyleWord(true);

    // JScrollPane to make code scrollable if it gets long
    JScrollPane scrollPane = new JScrollPane(codeArea);
    scrollPane.setPreferredSize(new Dimension(450, 200));

    // Run button
    JButton runButton = new JButton("RUN");
    runButton.setFont(new Font("Arial", Font.BOLD, 14));
    runButton.setBackground(new Color(100, 149, 237)); // Light blue color
    runButton.setForeground(Color.WHITE);

    // Output label to display the result after clicking RUN
    JLabel outputLabel = new JLabel("Output will be shown here");
    outputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    outputLabel.setForeground(Color.LIGHT_GRAY);

    // ActionListener for Run button
    runButton.addActionListener(e -> {
        outputLabel.setText(outputText);
    });

    // Add components to project panel
    projectPanel.add(projectTitle);
    projectPanel.add(projectDescription);
    projectPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    projectPanel.add(scrollPane);
    projectPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    projectPanel.add(runButton);
    projectPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    projectPanel.add(outputLabel);

    return projectPanel;
}

// Main Projects Panel
private JPanel createProjectsPanel() {
    JPanel projectsPanel = new JPanel();
    projectsPanel.setLayout(new BoxLayout(projectsPanel, BoxLayout.Y_AXIS));
    projectsPanel.setBackground(new Color(44, 47, 51));

    // Title for the projects panel
    JLabel title = new JLabel("Our Projects");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(Color.WHITE);

    // Add multiple projects
    projectsPanel.add(title);
    projectsPanel.add(createProject(
    "1. Hello World",
    "- This program prints 'Hello, World!' to the console.",
    "public class HelloWorld {\n"
    + "    public static void main(String[] args) {\n"
    + "        System.out.println(\"Hello, World!\");\n"
    + "    }\n"
    + "}",
    "Hello, World!"
));

projectsPanel.add(createProject(
    "2. Add Two Numbers",
    "- This program adds two numbers.",
    "public class AddNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 5;\n"
    + "        int b = 10;\n"
    + "        System.out.println(\"Sum: \" + (a + b));\n"
    + "    }\n"
    + "}",
    "Sum: 15"
));

projectsPanel.add(createProject(
    "3. Subtraction",
    "- This program subtracts one number from another.",
    "public class Subtraction {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 15;\n"
    + "        int b = 5;\n"
    + "        System.out.println(\"Difference: \" + (a - b));\n"
    + "    }\n"
    + "}",
    "Difference: 10"
));

projectsPanel.add(createProject(
    "4. Multiplication",
    "- This program multiplies two numbers.",
    "public class Multiplication {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 6;\n"
    + "        int b = 7;\n"
    + "        System.out.println(\"Product: \" + (a * b));\n"
    + "    }\n"
    + "}",
    "Product: 42"
));

projectsPanel.add(createProject(
    "5. Division",
    "- This program divides one number by another.",
    "public class Division {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 20;\n"
    + "        int b = 4;\n"
    + "        System.out.println(\"Quotient: \" + (a / b));\n"
    + "    }\n"
    + "}",
    "Quotient: 5"
));

projectsPanel.add(createProject(
    "6. Modulus",
    "- This program calculates the remainder of a division.",
    "public class Modulus {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 10;\n"
    + "        int b = 3;\n"
    + "        System.out.println(\"Remainder: \" + (a % b));\n"
    + "    }\n"
    + "}",
    "Remainder: 1"
));

projectsPanel.add(createProject(
    "7. Swapping Variables",
    "- This program swaps the values of two variables.",
    "public class SwapVariables {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 10;\n"
    + "        int b = 20;\n"
    + "        int temp = a;\n"
    + "        a = b;\n"
    + "        b = temp;\n"
    + "        System.out.println(\"a: \" + a + \", b: \" + b);\n"
    + "    }\n"
    + "}",
    "a: 20, b: 10"
));

projectsPanel.add(createProject(
    "8. Finding Maximum of Two Numbers",
    "- This program finds the maximum of two numbers.",
    "public class MaxOfTwo {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 5;\n"
    + "        int b = 10;\n"
    + "        System.out.println(\"Maximum: \" + Math.max(a, b));\n"
    + "    }\n"
    + "}",
    "Maximum: 10"
));

projectsPanel.add(createProject(
    "9. Finding Minimum of Two Numbers",
    "- This program finds the minimum of two numbers.",
    "public class MinOfTwo {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 5;\n"
    + "        int b = 10;\n"
    + "        System.out.println(\"Minimum: \" + Math.min(a, b));\n"
    + "    }\n"
    + "}",
    "Minimum: 5"
));

projectsPanel.add(createProject(
    "10. Even or Odd Check",
    "- This program checks if a number is even or odd.",
    "public class EvenOrOdd {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 7;\n"
    + "        System.out.println(num + \" is \" + (num % 2 == 0 ? \"Even\" : \"Odd\"));\n"
    + "    }\n"
    + "}",
    "7 is Odd"
));

projectsPanel.add(createProject(
    "11. Temperature Conversion (Celsius to Fahrenheit)",
    "- This program converts temperature from Celsius to Fahrenheit.",
    "public class TempConversion {\n"
    + "    public static void main(String[] args) {\n"
    + "        double celsius = 25;\n"
    + "        double fahrenheit = (celsius * 9/5) + 32;\n"
    + "        System.out.println(\"Fahrenheit: \" + fahrenheit);\n"
    + "    }\n"
    + "}",
    "Fahrenheit: 77.0"
));

projectsPanel.add(createProject(
    "12. Area of a Circle",
    "- This program calculates the area of a circle given its radius.",
    "public class CircleArea {\n"
    + "    public static void main(String[] args) {\n"
    + "        double radius = 5;\n"
    + "        double area = Math.PI * radius * radius;\n"
    + "        System.out.println(\"Area of Circle: \" + area);\n"
    + "    }\n"
    + "}",
    "Area of Circle: 78.53981633974483"
));

projectsPanel.add(createProject(
    "13. Simple Interest Calculation",
    "- This program calculates simple interest based on principal, rate, and time.",
    "public class SimpleInterest {\n"
    + "    public static void main(String[] args) {\n"
    + "        double principal = 1000;\n"
    + "        double rate = 5;\n"
    + "        double time = 3;\n"
    + "        double interest = (principal * rate * time) / 100;\n"
    + "        System.out.println(\"Simple Interest: \" + interest);\n"
    + "    }\n"
    + "}",
    "Simple Interest: 150.0"
));

projectsPanel.add(createProject(
    "14. Compound Interest Calculation",
    "- This program calculates compound interest based on principal, rate, and time.",
    "public class CompoundInterest {\n"
    + "    public static void main(String[] args) {\n"
    + "        double principal = 1000;\n"
    + "        double rate = 5;\n"
    + "        double time = 3;\n"
    + "        double amount = principal * Math.pow((1 + rate / 100), time);\n"
    + "        double interest = amount - principal;\n"
    + "        System.out.println(\"Compound Interest: \" + interest);\n"
    + "    }\n"
    + "}",
    "Compound Interest: 157.62500000000023"
));

projectsPanel.add(createProject(
    "15. Finding Factorial of a Number",
    "- This program calculates the factorial of a number using a for loop.",
    "public class Factorial {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 5;\n"
    + "        int factorial = 1;\n"
    + "        for (int i = 1; i <= num; i++) {\n"
    + "            factorial *= i;\n"
    + "        }\n"
    + "        System.out.println(\"Factorial: \" + factorial);\n"
    + "    }\n"
    + "}",
    "Factorial: 120"
));

projectsPanel.add(createProject(
    "16. Palindrome Check",
    "- This program checks if a string is a palindrome.",
    "public class Palindrome {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"madam\";\n"
    + "        String reversed = new StringBuilder(str).reverse().toString();\n"
    + "        System.out.println(str + (str.equals(reversed) ? \" is a Palindrome\" : \" is not a Palindrome\"));\n"
    + "    }\n"
    + "}",
    "madam is a Palindrome"
));

projectsPanel.add(createProject(
    "17. Prime Number Check",
    "- This program checks if a number is prime.",
    "public class PrimeCheck {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 29;\n"
    + "        boolean isPrime = true;\n"
    + "        for (int i = 2; i <= Math.sqrt(num); i++) {\n"
    + "            if (num % i == 0) {\n"
    + "                isPrime = false;\n"
    + "                break;\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(num + (isPrime ? \" is a Prime Number\" : \" is not a Prime Number\"));\n"
    + "    }\n"
    + "}",
    "29 is a Prime Number"
));

projectsPanel.add(createProject(
    "18. Reverse a String",
    "- This program reverses a given string.",
    "public class ReverseString {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"Hello\";\n"
    + "        String reversed = new StringBuilder(str).reverse().toString();\n"
    + "        System.out.println(\"Reversed String: \" + reversed);\n"
    + "    }\n"
    + "}",
    "Reversed String: olleH"
));

projectsPanel.add(createProject(
    "19. Count Vowels in a String",
    "- This program counts the number of vowels in a string.",
    "public class CountVowels {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"Hello World\";\n"
    + "        int count = 0;\n"
    + "        for (char c : str.toCharArray()) {\n"
    + "            if (\"AEIOUaeiou\".indexOf(c) != -1) {\n"
    + "                count++;\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Number of Vowels: \" + count);\n"
    + "    }\n"
    + "}",
    "Number of Vowels: 3"
));

projectsPanel.add(createProject(
    "20. Count Consonants in a String",
    "- This program counts the number of consonants in a string.",
    "public class CountConsonants {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"Hello World\";\n"
    + "        int count = 0;\n"
    + "        for (char c : str.toCharArray()) {\n"
    + "            if (Character.isLetter(c) && \"AEIOUaeiou\".indexOf(c) == -1) {\n"
    + "                count++;\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Number of Consonants: \" + count);\n"
    + "    }\n"
    + "}",
    "Number of Consonants: 7"
));

projectsPanel.add(createProject(
    "21. Power of a Number",
    "- This program calculates the power of a number given a base and an exponent.",
    "public class PowerOfNumber {\n"
    + "    public static void main(String[] args) {\n"
    + "        double base = 2, exponent = 3;\n"
    + "        double result = Math.pow(base, exponent);\n"
    + "        System.out.println(\"Result: \" + result);\n"
    + "    }\n"
    + "}",
    "Result: 8.0"
));

projectsPanel.add(createProject(
    "22. Factorial Calculation",
    "- This program calculates the factorial of a number using a for loop.",
    "public class Factorial {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 5;\n"
    + "        int factorial = 1;\n"
    + "        for (int i = 1; i <= num; i++) {\n"
    + "            factorial *= i;\n"
    + "        }\n"
    + "        System.out.println(\"Factorial: \" + factorial);\n"
    + "    }\n"
    + "}",
    "Factorial: 120"
));

projectsPanel.add(createProject(
    "23. Check Palindrome",
    "- This program checks if a string is a palindrome by reversing it and comparing it to the original.",
    "public class PalindromeCheck {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"madam\";\n"
    + "        String reversed = new StringBuilder(str).reverse().toString();\n"
    + "        System.out.println(str + \" is \" + (str.equals(reversed) ? \"a Palindrome\" : \"not a Palindrome\"));\n"
    + "    }\n"
    + "}",
    "madam is a Palindrome"
));

projectsPanel.add(createProject(
    "24. Count the Number of Digits",
    "- This program counts the number of digits in a given integer.",
    "public class CountDigits {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 12345;\n"
    + "        int count = String.valueOf(num).length();\n"
    + "        System.out.println(\"Number of Digits: \" + count);\n"
    + "    }\n"
    + "}",
    "Number of Digits: 5"
));

projectsPanel.add(createProject(
    "25. Find ASCII Value of a Character",
    "- This program finds the ASCII value of a given character.",
    "public class ASCIIValue {\n"
    + "    public static void main(String[] args) {\n"
    + "        char ch = 'A';\n"
    + "        System.out.println(\"ASCII Value of \" + ch + \": \" + (int) ch);\n"
    + "    }\n"
    + "}",
    "ASCII Value of A: 65"
));

projectsPanel.add(createProject(
    "26. Reverse a String",
    "- This program reverses a given string and displays the result.",
    "public class ReverseString {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"Hello\";\n"
    + "        String reversed = new StringBuilder(str).reverse().toString();\n"
    + "        System.out.println(\"Reversed String: \" + reversed);\n"
    + "    }\n"
    + "}",
    "Reversed String: olleH"
));

projectsPanel.add(createProject(
    "27. Find Largest of Three Numbers",
    "- This program finds the largest number among three given numbers.",
    "public class LargestOfThree {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 5, b = 10, c = 3;\n"
    + "        int largest = Math.max(a, Math.max(b, c));\n"
    + "        System.out.println(\"Largest Number: \" + largest);\n"
    + "    }\n"
    + "}",
    "Largest Number: 10"
));

projectsPanel.add(createProject(
    "28. Check for a Valid Triangle",
    "- This program checks if three given lengths can form a valid triangle.",
    "public class ValidTriangle {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 3, b = 4, c = 5;\n"
    + "        System.out.println(\"Valid Triangle: \" + (a + b > c && a + c > b && b + c > a));\n"
    + "    }\n"
    + "}",
    "Valid Triangle: true"
));

projectsPanel.add(createProject(
    "29. Sum of Digits",
    "- This program calculates the sum of the digits of a given integer.",
    "public class SumOfDigits {\n"
    + "    public static void main(String[] args) {\n"
    + "        int num = 123;\n"
    + "        int sum = 0;\n"
    + "        while (num != 0) {\n"
    + "            sum += num % 10;\n"
    + "            num /= 10;\n"
    + "        }\n"
    + "        System.out.println(\"Sum of Digits: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum of Digits: 6"
));

projectsPanel.add(createProject(
    "30. Fibonacci Series (First Two Terms)",
    "- This program displays the first two terms of the Fibonacci series.",
    "public class Fibonacci {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 0, b = 1;\n"
    + "        System.out.println(\"Fibonacci Series: \" + a + \", \" + b);\n"
    + "    }\n"
    + "}",
    "Fibonacci Series: 0, 1"
));


projectsPanel.add(createProject(
    "40. Print Numbers 1 to 10",
    "- This program prints the numbers from 1 to 10 using a for loop.",
    "public class PrintNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(i);\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "1\n2\n3\n4\n5\n6\n7\n8\n9\n10"
));

projectsPanel.add(createProject(
    "41. Print Even Numbers from 1 to 20",
    "- This program prints even numbers from 1 to 20 using a while loop.",
    "public class PrintEvenNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int i = 1;\n"
    + "        while (i <= 20) {\n"
    + "            if (i % 2 == 0) {\n"
    + "                System.out.println(i);\n"
    + "            }\n"
    + "            i++;\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "2\n4\n6\n8\n10\n12\n14\n16\n18\n20"
));

projectsPanel.add(createProject(
    "42. Print Odd Numbers from 1 to 20",
    "- This program prints odd numbers from 1 to 20 using a do-while loop.",
    "public class PrintOddNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int i = 1;\n"
    + "        do {\n"
    + "            System.out.println(i);\n"
    + "            i += 2;\n"
    + "        } while (i <= 20);\n"
    + "    }\n"
    + "}",
    "1\n3\n5\n7\n9\n11\n13\n15\n17\n19"
));

projectsPanel.add(createProject(
    "43. Print Multiplication Table of 5",
    "- This program prints the multiplication table of 5 using a for loop.",
    "public class MultiplicationTable {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(\"5 x \" + i + \" = \" + (5 * i));\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50"
));

projectsPanel.add(createProject(
    "44. Calculate Sum of First 10 Natural Numbers",
    "- This program calculates the sum of the first 10 natural numbers using a for loop.",
    "public class SumNaturalNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int sum = 0;\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            sum += i;\n"
    + "        }\n"
    + "        System.out.println(\"Sum: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum: 55"
));

projectsPanel.add(createProject(
    "45. Print Fibonacci Series up to 10 Terms",
    "- This program prints the Fibonacci series up to 10 terms using a for loop.",
    "public class FibonacciSeries {\n"
    + "    public static void main(String[] args) {\n"
    + "        int a = 0, b = 1;\n"
    + "        System.out.print(a + \", \" + b);\n"
    + "        for (int i = 2; i < 10; i++) {\n"
    + "            int next = a + b;\n"
    + "            System.out.print(\", \" + next);\n"
    + "            a = b;\n"
    + "            b = next;\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "0, 1, 1, 2, 3, 5, 8, 13, 21"
));

projectsPanel.add(createProject(
    "46. Count Down from 10 to 1",
    "- This program counts down from 10 to 1 using a for loop.",
    "public class Countdown {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 10; i > 0; i--) {\n"
    + "            System.out.println(i);\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "10\n9\n8\n7\n6\n5\n4\n3\n2\n1"
));

projectsPanel.add(createProject(
    "47. Print Squares of Numbers from 1 to 10",
    "- This program prints the squares of numbers from 1 to 10 using a for loop.",
    "public class PrintSquares {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(\"Square of \" + i + \" = \" + (i * i));\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Square of 1 = 1\nSquare of 2 = 4\nSquare of 3 = 9\nSquare of 4 = 16\nSquare of 5 = 25\nSquare of 6 = 36\nSquare of 7 = 49\nSquare of 8 = 64\nSquare of 9 = 81\nSquare of 10 = 100"
));

projectsPanel.add(createProject(
    "48. Print Table of 2",
    "- This program prints the multiplication table of 2 using a for loop.",
    "public class TableOfTwo {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(\"2 x \" + i + \" = \" + (2 * i));\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20"
));

projectsPanel.add(createProject(
    "49. Find the Sum of Even Numbers from 1 to 100",
    "- This program calculates the sum of even numbers from 1 to 100 using a for loop.",
    "public class SumEvenNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int sum = 0;\n"
    + "        for (int i = 2; i <= 100; i += 2) {\n"
    + "            sum += i;\n"
    + "        }\n"
    + "        System.out.println(\"Sum of Even Numbers: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum of Even Numbers: 2550"
));

projectsPanel.add(createProject(
    "50. Find the Sum of Odd Numbers from 1 to 100",
    "- This program calculates the sum of odd numbers from 1 to 100 using a for loop.",
    "public class SumOddNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        int sum = 0;\n"
    + "        for (int i = 1; i <= 100; i += 2) {\n"
    + "            sum += i;\n"
    + "        }\n"
    + "        System.out.println(\"Sum of Odd Numbers: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum of Odd Numbers: 2500"
));


projectsPanel.add(createProject(
    "51. Print the Factorial of 5",
    "- This program calculates the factorial of 5 using a for loop.",
    "public class Factorial {\n"
    + "    public static void main(String[] args) {\n"
    + "        int factorial = 1;\n"
    + "        for (int i = 1; i <= 5; i++) {\n"
    + "            factorial *= i;\n"
    + "        }\n"
    + "        System.out.println(\"Factorial of 5: \" + factorial);\n"
    + "    }\n"
    + "}",
    "Factorial of 5: 120"
));

projectsPanel.add(createProject(
    "52. Print a Pyramid of Stars",
    "- This program prints a pyramid of stars using nested loops.",
    "public class StarPyramid {\n"
    + "    public static void main(String[] args) {\n"
    + "        int rows = 5;\n"
    + "        for (int i = 1; i <= rows; i++) {\n"
    + "            for (int j = rows; j > i; j--) {\n"
    + "                System.out.print(\" \");\n"
    + "            }\n"
    + "            for (int j = 1; j <= (2 * i - 1); j++) {\n"
    + "                System.out.print(\"*\");\n"
    + "            }\n"
    + "            System.out.println();\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "     *\n" +
    "    ***\n" +
    "   *****\n" +
    "  *******\n" +
    " *********\n"
));

projectsPanel.add(createProject(
    "53. Print the First 10 Cube Numbers",
    "- This program prints the cube of numbers from 1 to 10 using a for loop.",
    "public class PrintCubes {\n"
    + "    public static void main(String[] args) {\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(\"Cube of \" + i + \" = \" + (i * i * i));\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Cube of 1 = 1\nCube of 2 = 8\nCube of 3 = 27\nCube of 4 = 64\nCube of 5 = 125\nCube of 6 = 216\nCube of 7 = 343\nCube of 8 = 512\nCube of 9 = 729\nCube of 10 = 1000"
));

projectsPanel.add(createProject(
    "54. Print a Rectangle of Stars",
    "- This program prints a rectangle of stars using nested loops.",
    "public class StarRectangle {\n"
    + "    public static void main(String[] args) {\n"
    + "        int rows = 5;\n"
    + "        int cols = 10;\n"
    + "        for (int i = 0; i < rows; i++) {\n"
    + "            for (int j = 0; j < cols; j++) {\n"
    + "                System.out.print(\"*\");\n"
    + "            }\n"
    + "            System.out.println();\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "**********\n**********\n**********\n**********\n**********"
));

projectsPanel.add(createProject(
    "55. Print Prime Numbers from 1 to 100",
    "- This program prints all prime numbers from 1 to 100 using nested loops.",
    "public class PrimeNumbers {\n"
    + "    public static void main(String[] args) {\n"
    + "        System.out.println(\"Prime Numbers from 1 to 100:\");\n"
    + "        for (int num = 2; num <= 100; num++) {\n"
    + "            boolean isPrime = true;\n"
    + "            for (int i = 2; i <= Math.sqrt(num); i++) {\n"
    + "                if (num % i == 0) {\n"
    + "                    isPrime = false;\n"
    + "                    break;\n"
    + "                }\n"
    + "            }\n"
    + "            if (isPrime) {\n"
    + "                System.out.print(num + \" \");\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Prime Numbers from 1 to 100:\n2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 "
));

projectsPanel.add(createProject(
    "56. Generate a Random Number (1-100) 10 Times",
    "- This program generates and prints a random number between 1 and 100, 10 times using a for loop.",
    "import java.util.Random;\n\n" +
    "public class RandomNumbers {\n" +
    "    public static void main(String[] args) {\n" +
    "        Random rand = new Random();\n" +
    "        for (int i = 0; i < 10; i++) {\n" +
    "            int randomNum = rand.nextInt(100) + 1;\n" +
    "            System.out.println(\"Random Number: \" + randomNum);\n" +
    "        }\n" +
    "    }\n" +
    "}",
    "Random Number: 45\nRandom Number: 32\nRandom Number: 78\nRandom Number: 15\nRandom Number: 94\nRandom Number: 11\nRandom Number: 66\nRandom Number: 83\nRandom Number: 22\nRandom Number: 59"
));

projectsPanel.add(createProject(
    "57. Print the ASCII Values of Characters A to Z",
    "- This program prints the ASCII values of characters A to Z using a for loop.",
    "public class AsciiValues {\n" +
    "    public static void main(String[] args) {\n" +
    "        for (char c = 'A'; c <= 'Z'; c++) {\n" +
    "            System.out.println(\"ASCII value of \" + c + \" = \" + (int) c);\n" +
    "        }\n" +
    "    }\n" +
    "}",
    "ASCII value of A = 65\nASCII value of B = 66\nASCII value of C = 67\n...\nASCII value of Z = 90"
));

projectsPanel.add(createProject(
    "58. Calculate the Sum of Digits of a Number (12345)",
    "- This program calculates the sum of digits of the number 12345 using a while loop.",
    "public class SumOfDigits {\n" +
    "    public static void main(String[] args) {\n" +
    "        int number = 12345;\n" +
    "        int sum = 0;\n" +
    "        while (number > 0) {\n" +
    "            sum += number % 10;\n" +
    "            number /= 10;\n" +
    "        }\n" +
    "        System.out.println(\"Sum of digits: \" + sum);\n" +
    "    }\n" +
    "}",
    "Sum of digits: 15"
));

projectsPanel.add(createProject(
    "59. Print Palindrome Numbers from 1 to 100",
    "- This program prints all palindrome numbers from 1 to 100 using a for loop.",
    "public class PalindromeNumbers {\n" +
    "    public static void main(String[] args) {\n" +
    "        System.out.println(\"Palindrome Numbers from 1 to 100:\");\n" +
    "        for (int i = 1; i <= 100; i++) {\n" +
    "            int num = i, reversed = 0;\n" +
    "            while (num > 0) {\n" +
    "                reversed = reversed * 10 + num % 10;\n" +
    "                num /= 10;\n" +
    "            }\n" +
    "            if (i == reversed) {\n" +
    "                System.out.print(i + \" \");\n" +
    "            }\n" +
    "        }\n" +
    "    }\n" +
    "}",
    "Palindrome Numbers from 1 to 100:\n1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99"
));

projectsPanel.add(createProject(
    "60. Print the First 10 Triangular Numbers",
    "- This program prints the first 10 triangular numbers using a for loop.",
    "public class TriangularNumbers {\n" +
    "    public static void main(String[] args) {\n" +
    "        System.out.println(\"First 10 Triangular Numbers:\");\n" +
    "        for (int i = 1; i <= 10; i++) {\n" +
    "            int triangularNumber = (i * (i + 1)) / 2;\n" +
    "            System.out.println(\"Triangular Number \" + i + \" = \" + triangularNumber);\n" +
    "        }\n" +
    "    }\n" +
    "}",
    "First 10 Triangular Numbers:\nTriangular Number 1 = 1\nTriangular Number 2 = 3\nTriangular Number 3 = 6\nTriangular Number 4 = 10\nTriangular Number 5 = 15\nTriangular Number 6 = 21\nTriangular Number 7 = 28\nTriangular Number 8 = 36\nTriangular Number 9 = 45\nTriangular Number 10 = 55"
));

projectsPanel.add(createProject(
    "61. Reverse an Array",
    "- This program reverses an array of integers.",
    "public class ReverseArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 3, 4, 5};\n"
    + "        int n = arr.length;\n"
    + "        for (int i = 0; i < n / 2; i++) {\n"
    + "            int temp = arr[i];\n"
    + "            arr[i] = arr[n - 1 - i];\n"
    + "            arr[n - 1 - i] = temp;\n"
    + "        }\n"
    + "        System.out.println(Arrays.toString(arr));\n"
    + "    }\n"
    + "}",
    "[5, 4, 3, 2, 1]"
));

projectsPanel.add(createProject(
    "62. Find the Maximum and Minimum in an Array",
    "- This program finds the maximum and minimum values in an array of integers.",
    "public class MaxMinArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {10, 20, 5, 30, 15};\n"
    + "        int max = arr[0];\n"
    + "        int min = arr[0];\n"
    + "        for (int i = 1; i < arr.length; i++) {\n"
    + "            if (arr[i] > max) {\n"
    + "                max = arr[i];\n"
    + "            }\n"
    + "            if (arr[i] < min) {\n"
    + "                min = arr[i];\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Max: \" + max + \", Min: \" + min);\n"
    + "    }\n"
    + "}",
    "Max: 30, Min: 5"
));

projectsPanel.add(createProject(
    "63. Count the Frequency of Elements in an Array",
    "- This program counts how many times each element appears in an array.",
    "public class FrequencyCount {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 2, 3, 3, 3, 4};\n"
    + "        int[] frequency = new int[arr.length];\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            frequency[i] = 1;\n"
    + "            for (int j = i + 1; j < arr.length; j++) {\n"
    + "                if (arr[i] == arr[j]) {\n"
    + "                    frequency[i]++;\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Element Frequency:\");\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            if (frequency[i] > 0) {\n"
    + "                System.out.println(arr[i] + \" : \" + frequency[i]);\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Element Frequency:\n1 : 1\n2 : 2\n3 : 3\n4 : 1"
));

projectsPanel.add(createProject(
    "64. Merge Two Arrays",
    "- This program merges two arrays into a single array.",
    "public class MergeArrays {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr1 = {1, 2, 3};\n"
    + "        int[] arr2 = {4, 5, 6};\n"
    + "        int[] merged = new int[arr1.length + arr2.length];\n"
    + "        System.arraycopy(arr1, 0, merged, 0, arr1.length);\n"
    + "        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);\n"
    + "        System.out.println(Arrays.toString(merged));\n"
    + "    }\n"
    + "}",
    "[1, 2, 3, 4, 5, 6]"
));

projectsPanel.add(createProject(
    "65. Rotate an Array",
    "- This program rotates an array to the right by a specified number of positions.",
    "public class RotateArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 3, 4, 5};\n"
    + "        int k = 2; // Rotate by 2 positions\n"
    + "        int n = arr.length;\n"
    + "        k = k % n; // In case k > n\n"
    + "        int[] rotated = new int[n];\n"
    + "        for (int i = 0; i < n; i++) {\n"
    + "            rotated[(i + k) % n] = arr[i];\n"
    + "        }\n"
    + "        System.out.println(Arrays.toString(rotated));\n"
    + "    }\n"
    + "}",
    "[4, 5, 1, 2, 3]"
));

projectsPanel.add(createProject(
    "66. Check if Two Arrays are Equal",
    "- This program checks if two arrays are equal (have the same elements in the same order).",
    "public class CheckEqualArrays {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr1 = {1, 2, 3};\n"
    + "        int[] arr2 = {1, 2, 3};\n"
    + "        boolean areEqual = Arrays.equals(arr1, arr2);\n"
    + "        System.out.println(\"Arrays are equal: \" + areEqual);\n"
    + "    }\n"
    + "}",
    "Arrays are equal: true"
));

projectsPanel.add(createProject(
    "67. Remove Duplicates from an Array",
    "- This program removes duplicate elements from an array.",
    "import java.util.Arrays;\n\n" +
    "public class RemoveDuplicates {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 2, 3, 4, 4, 5};\n"
    + "        int n = arr.length;\n"
    + "        int[] temp = new int[n];\n"
    + "        int j = 0;\n"
    + "        for (int i = 0; i < n - 1; i++) {\n"
    + "            if (arr[i] != arr[i + 1]) {\n"
    + "                temp[j++] = arr[i];\n"
    + "            }\n"
    + "        }\n"
    + "        temp[j++] = arr[n - 1]; // Add last element\n"
    + "        int[] result = Arrays.copyOf(temp, j);\n"
    + "        System.out.println(Arrays.toString(result));\n"
    + "    }\n"
    + "}",
    "[1, 2, 3, 4, 5]"
));

projectsPanel.add(createProject(
    "68. Find the Second Largest Element in an Array",
    "- This program finds the second largest element in an array.",
    "public class SecondLargest {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {10, 20, 4, 45, 99};\n"
    + "        int largest = Integer.MIN_VALUE;\n"
    + "        int secondLargest = Integer.MIN_VALUE;\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            if (arr[i] > largest) {\n"
    + "                secondLargest = largest;\n"
    + "                largest = arr[i];\n"
    + "            } else if (arr[i] > secondLargest && arr[i] != largest) {\n"
    + "                secondLargest = arr[i];\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Second Largest: \" + secondLargest);\n"
    + "    }\n"
    + "}",
    "Second Largest: 45"
));

projectsPanel.add(createProject(
    "69. Sort an Array",
    "- This program sorts an array of integers in ascending order.",
    "import java.util.Arrays;\n\n" +
    "public class SortArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {5, 3, 8, 1, 2};\n"
    + "        Arrays.sort(arr);\n"
    + "        System.out.println(Arrays.toString(arr));\n"
    + "    }\n"
    + "}",
    "[1, 2, 3, 5, 8]"
));

projectsPanel.add(createProject(
    "70. Find Common Elements in Two Arrays",
    "- This program finds the common elements between two arrays.",
    "public class CommonElements {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr1 = {1, 2, 3, 4};\n"
    + "        int[] arr2 = {3, 4, 5, 6};\n"
    + "        System.out.print(\"Common Elements: \");\n"
    + "        for (int i = 0; i < arr1.length; i++) {\n"
    + "            for (int j = 0; j < arr2.length; j++) {\n"
    + "                if (arr1[i] == arr2[j]) {\n"
    + "                    System.out.print(arr1[i] + \" \");\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Common Elements: 3 4 "
));

projectsPanel.add(createProject(
    "71. Transpose a Matrix",
    "- This program transposes a 2D matrix (array of arrays).",
    "public class TransposeMatrix {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};\n"
    + "        int[][] transposed = new int[matrix[0].length][matrix.length];\n"
    + "        for (int i = 0; i < matrix.length; i++) {\n"
    + "            for (int j = 0; j < matrix[0].length; j++) {\n"
    + "                transposed[j][i] = matrix[i][j];\n"
    + "            }\n"
    + "        }\n"
    + "        for (int[] row : transposed) {\n"
    + "            for (int value : row) {\n"
    + "                System.out.print(value + \" \");\n"
    + "            }\n"
    + "            System.out.println();\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "1 4 7 \n2 5 8 \n3 6 9 "
));

projectsPanel.add(createProject(
    "72. Sum of All Elements in an Array",
    "- This program calculates the sum of all elements in an array.",
    "public class SumOfElements {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] numbers = {10, 20, 30, 40, 50};\n"
    + "        int sum = 0;\n"
    + "        for (int num : numbers) {\n"
    + "            sum += num;\n"
    + "        }\n"
    + "        System.out.println(\"Sum: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum: 150"
));

projectsPanel.add(createProject(
    "73. Check for Symmetry in an Array",
    "- This program checks if an array is symmetric (the same forwards and backwards).",
    "public class CheckSymmetry {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 3, 2, 1};\n"
    + "        boolean isSymmetric = true;\n"
    + "        for (int i = 0; i < arr.length / 2; i++) {\n"
    + "            if (arr[i] != arr[arr.length - 1 - i]) {\n"
    + "                isSymmetric = false;\n"
    + "                break;\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Is symmetric: \" + isSymmetric);\n"
    + "    }\n"
    + "}",
    "Is symmetric: true"
));

projectsPanel.add(createProject(
    "74. Find the Missing Number in an Array",
    "- This program identifies a missing number in a sequential array.",
    "public class MissingNumber {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 4, 5}; // Missing number is 3\n"
    + "        int n = arr.length + 1;\n"
    + "        int total = n * (n + 1) / 2;\n"
    + "        int sum = 0;\n"
    + "        for (int num : arr) {\n"
    + "            sum += num;\n"
    + "        }\n"
    + "        int missingNumber = total - sum;\n"
    + "        System.out.println(\"Missing number: \" + missingNumber);\n"
    + "    }\n"
    + "}",
    "Missing number: 3"
));

projectsPanel.add(createProject(
    "75. Implement a Dynamic Array",
    "- This program demonstrates a simple dynamic array implementation that can grow as needed.",
    "import java.util.Arrays;\n"
    + "public class DynamicArray {\n"
    + "    private int[] arr;\n"
    + "    private int size;\n"
    + "    private int capacity;\n"
    + "    \n"
    + "    public DynamicArray() {\n"
    + "        capacity = 2;\n"
    + "        arr = new int[capacity];\n"
    + "        size = 0;\n"
    + "    }\n"
    + "    \n"
    + "    public void add(int value) {\n"
    + "        if (size == capacity) {\n"
    + "            capacity *= 2;\n"
    + "            arr = Arrays.copyOf(arr, capacity);\n"
    + "        }\n"
    + "        arr[size++] = value;\n"
    + "    }\n"
    + "    \n"
    + "    public void printArray() {\n"
    + "        for (int i = 0; i < size; i++) {\n"
    + "            System.out.print(arr[i] + \" \");\n"
    + "        }\n"
    + "        System.out.println();\n"
    + "    }\n"
    + "    \n"
    + "    public static void main(String[] args) {\n"
    + "        DynamicArray dynamicArray = new DynamicArray();\n"
    + "        dynamicArray.add(1);\n"
    + "        dynamicArray.add(2);\n"
    + "        dynamicArray.add(3);\n"
    + "        dynamicArray.printArray();\n"
    + "    }\n"
    + "}",
    "1 2 3 "
));

projectsPanel.add(createProject(
    "76. Kth Largest Element in an Array",
    "- This program finds the kth largest element in an array.",
    "import java.util.Arrays;\n"
    + "public class KthLargest {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {3, 2, 1, 5, 6, 4};\n"
    + "        int k = 2; // Find 2nd largest\n"
    + "        Arrays.sort(arr);\n"
    + "        System.out.println(k + \"th largest element: \" + arr[arr.length - k]);\n"
    + "    }\n"
    + "}",
    "2th largest element: 5"
));

projectsPanel.add(createProject(
    "77. Frequency of Characters in a String",
    "- This program counts the frequency of each character in a string using an array.",
    "public class CharacterFrequency {\n"
    + "    public static void main(String[] args) {\n"
    + "        String str = \"hello world\";\n"
    + "        int[] frequency = new int[256];\n"
    + "        for (char c : str.toCharArray()) {\n"
    + "            frequency[c]++;\n"
    + "        }\n"
    + "        for (int i = 0; i < frequency.length; i++) {\n"
    + "            if (frequency[i] > 0) {\n"
    + "                System.out.println((char) i + \": \" + frequency[i]);\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "h: 1\nl: 3\ne: 1\no: 2\n : 1\nw: 1\nr: 1\nd: 1"
));

projectsPanel.add(createProject(
    "78. Find the Intersection of Two Arrays",
    "- This program finds the intersection of two arrays (elements common to both).",
    "import java.util.HashSet;\n"
    + "import java.util.Set;\n"
    + "public class ArrayIntersection {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr1 = {1, 2, 3, 4};\n"
    + "        int[] arr2 = {3, 4, 5, 6};\n"
    + "        Set<Integer> intersection = new HashSet<>();\n"
    + "        for (int num : arr1) {\n"
    + "            intersection.add(num);\n"
    + "        }\n"
    + "        for (int num : arr2) {\n"
    + "            if (intersection.contains(num)) {\n"
    + "                System.out.println(num);\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "3\n4"
));

projectsPanel.add(createProject(
    "79. Replace Elements in an Array",
    "- This program replaces all occurrences of a specific value in an array with a new value.",
    "public class ReplaceElements {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 3, 2, 4};\n"
    + "        int oldValue = 2;\n"
    + "        int newValue = 5;\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            if (arr[i] == oldValue) {\n"
    + "                arr[i] = newValue;\n"
    + "            }\n"
    + "        }\n"
    + "        for (int value : arr) {\n"
    + "            System.out.print(value + \" \");\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "1 5 3 5 4 "
));

projectsPanel.add(createProject(
    "80. Array Rotation (Left and Right)",
    "- This program rotates an array both to the left and to the right based on user input.",
    "import java.util.Arrays;\n"
    + "public class ArrayRotation {\n"
    + "    public static void rotateLeft(int[] arr, int d) {\n"
    + "        int n = arr.length;\n"
    + "        d = d % n;\n"
    + "        reverse(arr, 0, d - 1);\n"
    + "        reverse(arr, d, n - 1);\n"
    + "        reverse(arr, 0, n - 1);\n"
    + "    }\n"
    + "    \n"
    + "    public static void reverse(int[] arr, int start, int end) {\n"
    + "        while (start < end) {\n"
    + "            int temp = arr[start];\n"
    + "            arr[start] = arr[end];\n"
    + "            arr[end] = temp;\n"
    + "            start++;\n"
    + "            end--;\n"
    + "        }\n"
    + "    }\n"
    + "    \n"
    + "    public static void main(String[] args) {\n"
    + "        int[] arr = {1, 2, 3, 4, 5};\n"
    + "        int d = 2; // Rotate left by 2\n"
    + "        rotateLeft(arr, d);\n"
    + "        System.out.println(\"Array after left rotation: \" + Arrays.toString(arr));\n"
    + "    }\n"
    + "}",
    "Array after left rotation: [3, 4, 5, 1, 2]"
));

projectsPanel.add(createProject(
    "81. 3D Array Initialization and Display",
    "- This program initializes a 3D array with sample values and displays its contents.",
    "public class ThreeDArrayDisplay {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][][] arr = {\n"
    + "            {\n"
    + "                {1, 2, 3},\n"
    + "                {4, 5, 6}\n"
    + "            },\n"
    + "            {\n"
    + "                {7, 8, 9},\n"
    + "                {10, 11, 12}\n"
    + "            }\n"
    + "        };\n"
    + "\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            System.out.println(\"Layer \" + (i + 1) + \":\");\n"
    + "            for (int j = 0; j < arr[i].length; j++) {\n"
    + "                for (int k = 0; k < arr[i][j].length; k++) {\n"
    + "                    System.out.print(arr[i][j][k] + \" \");\n"
    + "                }\n"
    + "                System.out.println();\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Layer 1:\n1 2 3 \n4 5 6 \nLayer 2:\n7 8 9 \n10 11 12 \n"
));

projectsPanel.add(createProject(
    "82. Sum of All Elements in a 3D Array",
    "- This program calculates and displays the sum of all elements in a 3D array.",
    "public class SumOf3DArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][][] arr = {\n"
    + "            {\n"
    + "                {1, 2, 3},\n"
    + "                {4, 5, 6}\n"
    + "            },\n"
    + "            {\n"
    + "                {7, 8, 9},\n"
    + "                {10, 11, 12}\n"
    + "            }\n"
    + "        };\n"
    + "\n"
    + "        int sum = 0;\n"
    + "        for (int[][] layer : arr) {\n"
    + "            for (int[] row : layer) {\n"
    + "                for (int num : row) {\n"
    + "                    sum += num;\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "\n"
    + "        System.out.println(\"Sum of all elements: \" + sum);\n"
    + "    }\n"
    + "}",
    "Sum of all elements: 78"
));

projectsPanel.add(createProject(
    "83. Transpose of a 3D Array",
    "- This program transposes a 3D array and displays the transposed result.",
    "public class Transpose3DArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][][] arr = {\n"
    + "            {\n"
    + "                {1, 2},\n"
    + "                {3, 4}\n"
    + "            },\n"
    + "            {\n"
    + "                {5, 6},\n"
    + "                {7, 8}\n"
    + "            }\n"
    + "        };\n"
    + "\n"
    + "        int layers = arr.length;\n"
    + "        int rows = arr[0].length;\n"
    + "        int cols = arr[0][0].length;\n"
    + "        int[][][] transposed = new int[cols][rows][layers];\n"
    + "\n"
    + "        for (int i = 0; i < layers; i++) {\n"
    + "            for (int j = 0; j < rows; j++) {\n"
    + "                for (int k = 0; k < cols; k++) {\n"
    + "                    transposed[k][j][i] = arr[i][j][k];\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "\n"
    + "        System.out.println(\"Transposed 3D Array:\");\n"
    + "        for (int i = 0; i < transposed.length; i++) {\n"
    + "            System.out.println(\"Layer \" + (i + 1) + \":\");\n"
    + "            for (int j = 0; j < transposed[i].length; j++) {\n"
    + "                for (int k = 0; k < transposed[i][j].length; k++) {\n"
    + "                    System.out.print(transposed[i][j][k] + \" \");\n"
    + "                }\n"
    + "                System.out.println();\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Transposed 3D Array:\nLayer 1:\n1 3 \n5 7 \nLayer 2:\n2 4 \n6 8 \n"
));

projectsPanel.add(createProject(
    "84. Find Maximum Value in a 3D Array",
    "- This program finds and displays the maximum value in a 3D array.",
    "public class MaxIn3DArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][][] arr = {\n"
    + "            {\n"
    + "                {1, 2, 3},\n"
    + "                {4, 5, 6}\n"
    + "            },\n"
    + "            {\n"
    + "                {7, 8, 9},\n"
    + "                {10, 11, 12}\n"
    + "            }\n"
    + "        };\n"
    + "\n"
    + "        int max = arr[0][0][0];\n"
    + "        for (int[][] layer : arr) {\n"
    + "            for (int[] row : layer) {\n"
    + "                for (int num : row) {\n"
    + "                    if (num > max) {\n"
    + "                        max = num;\n"
    + "                    }\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "\n"
    + "        System.out.println(\"Maximum value: \" + max);\n"
    + "    }\n"
    + "}",
    "Maximum value: 12"
));

projectsPanel.add(createProject(
    "85. Fill a 3D Array with Random Numbers",
    "- This program fills a 3D array with random integers and displays the filled array.",
    "import java.util.Random;\n"
    + "public class Random3DArray {\n"
    + "    public static void main(String[] args) {\n"
    + "        int[][][] arr = new int[2][2][2];\n"
    + "        Random rand = new Random();\n"
    + "\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            for (int j = 0; j < arr[i].length; j++) {\n"
    + "                for (int k = 0; k < arr[i][j].length; k++) {\n"
    + "                    arr[i][j][k] = rand.nextInt(100);\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "\n"
    + "        System.out.println(\"Randomly filled 3D Array:\");\n"
    + "        for (int i = 0; i < arr.length; i++) {\n"
    + "            System.out.println(\"Layer \" + (i + 1) + \":\");\n"
    + "            for (int j = 0; j < arr[i].length; j++) {\n"
    + "                for (int k = 0; k < arr[i][j].length; k++) {\n"
    + "                    System.out.print(arr[i][j][k] + \" \");\n"
    + "                }\n"
    + "                System.out.println();\n"
    + "            }\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Randomly filled 3D Array:\nLayer 1:\n45 67 \n12 34 \nLayer 2:\n23 89 \n56 78 \n"
));

projectsPanel.add(createProject(
    "86. Student Management System",
    "- This program manages student information by storing attributes like name, age, and grades, and implements methods for adding, updating, and displaying student details.",
    "class Student {\n"
    + "    private String name;\n"
    + "    private int age;\n"
    + "    private double grade;\n"
    + "    \n"
    + "    public Student(String name, int age, double grade) {\n"
    + "        this.name = name;\n"
    + "        this.age = age;\n"
    + "        this.grade = grade;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayInfo() {\n"
    + "        System.out.println(\"Name: \" + name + \", Age: \" + age + \", Grade: \" + grade);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Student student1 = new Student(\"John Doe\", 20, 85.5);\n"
    + "        Student student2 = new Student(\"Jane Smith\", 22, 90.0);\n"
    + "        student1.displayInfo();\n"
    + "        student2.displayInfo();\n"
    + "    }\n"
    + "}",
    "Name: John Doe, Age: 20, Grade: 85.5\n"
    + "Name: Jane Smith, Age: 22, Grade: 90.0"
));

projectsPanel.add(createProject(
    "87. Library System",
    "- This program simulates a simple library management system using classes for Book, Member, and Library, implementing features to add books and lend them to members.",
    "class Book {\n"
    + "    private String title;\n"
    + "    private String author;\n"
    + "    private boolean isLent;\n"
    + "    \n"
    + "    public Book(String title, String author) {\n"
    + "        this.title = title;\n"
    + "        this.author = author;\n"
    + "        this.isLent = false;\n"
    + "    }\n"
    + "    \n"
    + "    public void lend() {\n"
    + "        isLent = true;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayInfo() {\n"
    + "        System.out.println(\"Title: \" + title + \", Author: \" + author + \", Lent: \" + isLent);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Book book1 = new Book(\"The Great Gatsby\", \"F. Scott Fitzgerald\");\n"
    + "        Book book2 = new Book(\"1984\", \"George Orwell\");\n"
    + "        book1.lend();\n"
    + "        book1.displayInfo();\n"
    + "        book2.displayInfo();\n"
    + "    }\n"
    + "}",
    "Title: The Great Gatsby, Author: F. Scott Fitzgerald, Lent: true\n"
    + "Title: 1984, Author: George Orwell, Lent: false"
));

projectsPanel.add(createProject(
    "88. Employee Management System",
    "- This program manages employee records with an Employee class that includes attributes like ID, name, and salary, along with methods for calculating bonuses and displaying details.",
    "class Employee {\n"
    + "    private int id;\n"
    + "    private String name;\n"
    + "    private double salary;\n"
    + "    \n"
    + "    public Employee(int id, String name, double salary) {\n"
    + "        this.id = id;\n"
    + "        this.name = name;\n"
    + "        this.salary = salary;\n"
    + "    }\n"
    + "    \n"
    + "    public double calculateBonus() {\n"
    + "        return salary * 0.10;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayInfo() {\n"
    + "        System.out.println(\"ID: \" + id + \", Name: \" + name + \", Salary: \" + salary + \", Bonus: \" + calculateBonus());\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Employee emp1 = new Employee(1, \"Alice\", 50000);\n"
    + "        Employee emp2 = new Employee(2, \"Bob\", 60000);\n"
    + "        emp1.displayInfo();\n"
    + "        emp2.displayInfo();\n"
    + "    }\n"
    + "}",
    "ID: 1, Name: Alice, Salary: 50000.0, Bonus: 5000.0\n"
    + "ID: 2, Name: Bob, Salary: 60000.0, Bonus: 6000.0"
));

projectsPanel.add(createProject(
    "89. Inventory Management System",
    "- This program simulates a simple inventory management system with a Product class that includes attributes like name, price, and quantity.",
    "class Product {\n"
    + "    private String name;\n"
    + "    private double price;\n"
    + "    private int quantity;\n"
    + "    \n"
    + "    public Product(String name, double price, int quantity) {\n"
    + "        this.name = name;\n"
    + "        this.price = price;\n"
    + "        this.quantity = quantity;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayInfo() {\n"
    + "        System.out.println(\"Product: \" + name + \", Price: \" + price + \", Quantity: \" + quantity);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Product prod1 = new Product(\"Laptop\", 1500.00, 10);\n"
    + "        Product prod2 = new Product(\"Smartphone\", 800.00, 25);\n"
    + "        prod1.displayInfo();\n"
    + "        prod2.displayInfo();\n"
    + "    }\n"
    + "}",
    "Product: Laptop, Price: 1500.0, Quantity: 10\n"
    + "Product: Smartphone, Price: 800.0, Quantity: 25"
));

projectsPanel.add(createProject(
    "90. Online Store",
    "- This program simulates an online store with classes for Product, Customer, and Order, implementing features for adding products to the cart and placing orders.",
    "class Product {\n"
    + "    private String name;\n"
    + "    private double price;\n"
    + "    \n"
    + "    public Product(String name, double price) {\n"
    + "        this.name = name;\n"
    + "        this.price = price;\n"
    + "    }\n"
    + "    \n"
    + "    public double getPrice() {\n"
    + "        return price;\n"
    + "    }\n"
    + "    \n"
    + "    public String getName() {\n"
    + "        return name;\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class Order {\n"
    + "    private Product product;\n"
    + "    \n"
    + "    public Order(Product product) {\n"
    + "        this.product = product;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayOrder() {\n"
    + "        System.out.println(\"Ordered: \" + product.getName() + \", Price: \" + product.getPrice());\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Product product1 = new Product(\"Headphones\", 150.00);\n"
    + "        Order order1 = new Order(product1);\n"
    + "        order1.displayOrder();\n"
    + "    }\n"
    + "}",
    "Ordered: Headphones, Price: 150.0"
));

projectsPanel.add(createProject(
    "91. Vehicle Management System",
    "- Create a base class `Vehicle` and derive subclasses like `Car`, `Truck`, and `Motorcycle`. Implement methods to display vehicle details and calculate mileage.",
    "class Vehicle {\n" +
    "    String brand;\n" +
    "    int year;\n" +
    "    \n" +
    "    public Vehicle(String brand, int year) {\n" +
    "        this.brand = brand;\n" +
    "        this.year = year;\n" +
    "    }\n" +
    "    \n" +
    "    public void displayDetails() {\n" +
    "        System.out.println(\"Brand: \" + brand + \", Year: \" + year);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class Car extends Vehicle {\n" +
    "    int doors;\n" +
    "    \n" +
    "    public Car(String brand, int year, int doors) {\n" +
    "        super(brand, year);\n" +
    "        this.doors = doors;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public void displayDetails() {\n" +
    "        super.displayDetails();\n" +
    "        System.out.println(\"Doors: \" + doors);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class Truck extends Vehicle {\n" +
    "    int payloadCapacity;\n" +
    "    \n" +
    "    public Truck(String brand, int year, int payloadCapacity) {\n" +
    "        super(brand, year);\n" +
    "        this.payloadCapacity = payloadCapacity;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public void displayDetails() {\n" +
    "        super.displayDetails();\n" +
    "        System.out.println(\"Payload Capacity: \" + payloadCapacity + \" kg\");\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "public class Main {\n" +
    "    public static void main(String[] args) {\n" +
    "        Car car = new Car(\"Toyota\", 2020, 4);\n" +
    "        Truck truck = new Truck(\"Ford\", 2018, 1000);\n" +
    "        \n" +
    "        car.displayDetails();\n" +
    "        System.out.println();\n" +
    "        truck.displayDetails();\n" +
    "    }\n" +
    "}",
    "Brand: Toyota, Year: 2020\n" +
    "Doors: 4\n" +
    "\n" +
    "Brand: Ford, Year: 2018\n" +
    "Payload Capacity: 1000 kg"
));

projectsPanel.add(createProject(
    "92. Shape Hierarchy",
    "- Design a shape hierarchy with a base class `Shape` and subclasses `Circle`, `Rectangle`, and `Triangle`. Implement methods to calculate area and perimeter for each shape.",
    "abstract class Shape {\n" +
    "    abstract double area();\n" +
    "    abstract double perimeter();\n" +
    "}\n" +
    "\n" +
    "class Circle extends Shape {\n" +
    "    double radius;\n" +
    "    \n" +
    "    public Circle(double radius) {\n" +
    "        this.radius = radius;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double area() {\n" +
    "        return Math.PI * radius * radius;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double perimeter() {\n" +
    "        return 2 * Math.PI * radius;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class Rectangle extends Shape {\n" +
    "    double length;\n" +
    "    double width;\n" +
    "    \n" +
    "    public Rectangle(double length, double width) {\n" +
    "        this.length = length;\n" +
    "        this.width = width;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double area() {\n" +
    "        return length * width;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double perimeter() {\n" +
    "        return 2 * (length + width);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class Triangle extends Shape {\n" +
    "    double base;\n" +
    "    double height;\n" +
    "    double side1;\n" +
    "    double side2;\n" +
    "    \n" +
    "    public Triangle(double base, double height, double side1, double side2) {\n" +
    "        this.base = base;\n" +
    "        this.height = height;\n" +
    "        this.side1 = side1;\n" +
    "        this.side2 = side2;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double area() {\n" +
    "        return 0.5 * base * height;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    double perimeter() {\n" +
    "        return base + side1 + side2;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "public class Main {\n" +
    "    public static void main(String[] args) {\n" +
    "        Shape circle = new Circle(5);\n" +
    "        Shape rectangle = new Rectangle(4, 6);\n" +
    "        Shape triangle = new Triangle(3, 4, 5, 6);\n" +
    "        \n" +
    "        System.out.println(\"Circle Area: \" + circle.area() + \", Perimeter: \" + circle.perimeter());\n" +
    "        System.out.println(\"Rectangle Area: \" + rectangle.area() + \", Perimeter: \" + rectangle.perimeter());\n" +
    "        System.out.println(\"Triangle Area: \" + triangle.area() + \", Perimeter: \" + triangle.perimeter());\n" +
    "    }\n" +
    "}",
    "Circle Area: 78.53981633974483, Perimeter: 31.41592653589793\n" +
    "Rectangle Area: 24.0, Perimeter: 20.0\n" +
    "Triangle Area: 6.0, Perimeter: 14.0"
));

projectsPanel.add(createProject(
    "93. Employee Types",
    "- Build an employee management system with a base class `Employee` and derived classes `FullTimeEmployee`, `PartTimeEmployee`, and `Intern`. Implement methods for calculating salaries and benefits.",
    "class Employee {\n" +
    "    String name;\n" +
    "    double baseSalary;\n" +
    "    \n" +
    "    public Employee(String name, double baseSalary) {\n" +
    "        this.name = name;\n" +
    "        this.baseSalary = baseSalary;\n" +
    "    }\n" +
    "    \n" +
    "    public double calculateSalary() {\n" +
    "        return baseSalary;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class FullTimeEmployee extends Employee {\n" +
    "    double benefits;\n" +
    "    \n" +
    "    public FullTimeEmployee(String name, double baseSalary, double benefits) {\n" +
    "        super(name, baseSalary);\n" +
    "        this.benefits = benefits;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public double calculateSalary() {\n" +
    "        return baseSalary + benefits;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class PartTimeEmployee extends Employee {\n" +
    "    int hoursWorked;\n" +
    "    double hourlyRate;\n" +
    "    \n" +
    "    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {\n" +
    "        super(name, hourlyRate * hoursWorked);\n" +
    "        this.hoursWorked = hoursWorked;\n" +
    "        this.hourlyRate = hourlyRate;\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public double calculateSalary() {\n" +
    "        return hourlyRate * hoursWorked;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class Intern extends Employee {\n" +
    "    public Intern(String name) {\n" +
    "        super(name, 0);\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public double calculateSalary() {\n" +
    "        return 0; // Interns may not receive salary\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "public class Main {\n" +
    "    public static void main(String[] args) {\n" +
    "        FullTimeEmployee fte = new FullTimeEmployee(\"Alice\", 50000, 15000);\n" +
    "        PartTimeEmployee pte = new PartTimeEmployee(\"Bob\", 20, 20);\n" +
    "        Intern intern = new Intern(\"Charlie\");\n" +
    "        \n" +
    "        System.out.println(fte.name + \" Salary: \" + fte.calculateSalary());\n" +
    "        System.out.println(pte.name + \" Salary: \" + pte.calculateSalary());\n" +
    "        System.out.println(intern.name + \" Salary: \" + intern.calculateSalary());\n" +
    "    }\n" +
    "}",
    "Alice Salary: 65000.0\n" +
    "Bob Salary: 400.0\n" +
    "Charlie Salary: 0.0"
));

projectsPanel.add(createProject(
    "94. Banking System",
    "- Create a simple banking system with a base class `Account` and derived classes `SavingsAccount` and `CheckingAccount`. Implement methods for depositing, withdrawing, and displaying balance.",
    "class Account {\n" +
    "    protected double balance;\n" +
    "    \n" +
    "    public Account(double initialBalance) {\n" +
    "        this.balance = initialBalance;\n" +
    "    }\n" +
    "    \n" +
    "    public void deposit(double amount) {\n" +
    "        balance += amount;\n" +
    "    }\n" +
    "    \n" +
    "    public void withdraw(double amount) {\n" +
    "        balance -= amount;\n" +
    "    }\n" +
    "    \n" +
    "    public double getBalance() {\n" +
    "        return balance;\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class SavingsAccount extends Account {\n" +
    "    public SavingsAccount(double initialBalance) {\n" +
    "        super(initialBalance);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class CheckingAccount extends Account {\n" +
    "    public CheckingAccount(double initialBalance) {\n" +
    "        super(initialBalance);\n" +
    "    }\n" +
    "    \n" +
    "    @Override\n" +
    "    public void withdraw(double amount) {\n" +
    "        if (amount <= balance) {\n" +
    "            balance -= amount;\n" +
    "        } else {\n" +
    "            System.out.println(\"Insufficient funds!\");\n" +
    "        }\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "public class Main {\n" +
    "    public static void main(String[] args) {\n" +
    "        SavingsAccount sa = new SavingsAccount(1000);\n" +
    "        CheckingAccount ca = new CheckingAccount(500);\n" +
    "        \n" +
    "        sa.deposit(200);\n" +
    "        ca.withdraw(600);\n" +
    "        \n" +
    "        System.out.println(\"Savings Account Balance: \" + sa.getBalance());\n" +
    "        System.out.println(\"Checking Account Balance: \" + ca.getBalance());\n" +
    "    }\n" +
    "}",
    "Savings Account Balance: 1200.0\n" +
    "Checking Account Balance: 500.0"
));

projectsPanel.add(createProject(
    "95. Library Management System",
    "- Develop a library management system with a base class `Book` and derived classes `FictionBook`, `NonFictionBook`, and `EBook`. Implement methods to display book information and check availability.",
    "class Book {\n" +
    "    String title;\n" +
    "    String author;\n" +
    "    boolean available;\n" +
    "    \n" +
    "    public Book(String title, String author) {\n" +
    "        this.title = title;\n" +
    "        this.author = author;\n" +
    "        this.available = true;\n" +
    "    }\n" +
    "    \n" +
    "    public void checkAvailability() {\n" +
    "        System.out.println(title + \" by \" + author + (available ? \" is available.\" : \" is not available.\"));\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class FictionBook extends Book {\n" +
    "    public FictionBook(String title, String author) {\n" +
    "        super(title, author);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class NonFictionBook extends Book {\n" +
    "    public NonFictionBook(String title, String author) {\n" +
    "        super(title, author);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "class EBook extends Book {\n" +
    "    public EBook(String title, String author) {\n" +
    "        super(title, author);\n" +
    "    }\n" +
    "}\n" +
    "\n" +
    "public class Main {\n" +
    "    public static void main(String[] args) {\n" +
    "        FictionBook fiction = new FictionBook(\"1984\", \"George Orwell\");\n" +
    "        NonFictionBook nonFiction = new NonFictionBook(\"Sapiens\", \"Yuval Noah Harari\");\n" +
    "        EBook eBook = new EBook(\"The Great Gatsby\", \"F. Scott Fitzgerald\");\n" +
    "        \n" +
    "        fiction.checkAvailability();\n" +
    "        nonFiction.checkAvailability();\n" +
    "        eBook.checkAvailability();\n" +
    "    }\n" +
    "}",
    "1984 by George Orwell is available.\n" +
    "Sapiens by Yuval Noah Harari is available.\n" +
    "The Great Gatsby by F. Scott Fitzgerald is available."
));

projectsPanel.add(createProject(
    "96. Payment System",
    "- This program demonstrates polymorphism by processing different payment methods (CreditCard, PayPal, BankTransfer) through a common interface.",
    "import java.util.ArrayList;\n"
    + "import java.util.List;\n"
    + "\n"
    + "abstract class PaymentMethod {\n"
    + "    abstract void processPayment(double amount);\n"
    + "}\n"
    + "\n"
    + "class CreditCard extends PaymentMethod {\n"
    + "    void processPayment(double amount) {\n"
    + "        System.out.println(\"Processing credit card payment of: $\" + amount);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class PayPal extends PaymentMethod {\n"
    + "    void processPayment(double amount) {\n"
    + "        System.out.println(\"Processing PayPal payment of: $\" + amount);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class BankTransfer extends PaymentMethod {\n"
    + "    void processPayment(double amount) {\n"
    + "        System.out.println(\"Processing bank transfer payment of: $\" + amount);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class PaymentDemo {\n"
    + "    public static void main(String[] args) {\n"
    + "        List<PaymentMethod> payments = new ArrayList<>();\n"
    + "        payments.add(new CreditCard());\n"
    + "        payments.add(new PayPal());\n"
    + "        payments.add(new BankTransfer());\n"
    + "\n"
    + "        double amount = 100.0;\n"
    + "        for (PaymentMethod payment : payments) {\n"
    + "            payment.processPayment(amount);\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Processing credit card payment of: $100.0\n"
    + "Processing PayPal payment of: $100.0\n"
    + "Processing bank transfer payment of: $100.0"
));

projectsPanel.add(createProject(
    "97. Media Player",
    "- This program simulates a media player that can play different media types (Audio, Video) using polymorphism.",
    "abstract class Media {\n"
    + "    abstract void play();\n"
    + "}\n"
    + "\n"
    + "class Audio extends Media {\n"
    + "    void play() {\n"
    + "        System.out.println(\"Playing audio file...\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class Video extends Media {\n"
    + "    void play() {\n"
    + "        System.out.println(\"Playing video file...\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class MediaPlayer {\n"
    + "    public static void main(String[] args) {\n"
    + "        Media media1 = new Audio();\n"
    + "        Media media2 = new Video();\n"
    + "\n"
    + "        media1.play();\n"
    + "        media2.play();\n"
    + "    }\n"
    + "}",
    "Playing audio file...\n"
    + "Playing video file..."
));

projectsPanel.add(createProject(
    "98. Animal Sounds",
    "- This program demonstrates polymorphism by using different animal classes (Dog, Cat) that implement a common method for making sounds.",
    "abstract class Animal {\n"
    + "    abstract void makeSound();\n"
    + "}\n"
    + "\n"
    + "class Dog extends Animal {\n"
    + "    void makeSound() {\n"
    + "        System.out.println(\"Woof!\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class Cat extends Animal {\n"
    + "    void makeSound() {\n"
    + "        System.out.println(\"Meow!\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class AnimalDemo {\n"
    + "    public static void main(String[] args) {\n"
    + "        Animal dog = new Dog();\n"
    + "        Animal cat = new Cat();\n"
    + "\n"
    + "        dog.makeSound();\n"
    + "        cat.makeSound();\n"
    + "    }\n"
    + "}",
    "Woof!\n"
    + "Meow!"
));

projectsPanel.add(createProject(
    "99. Shape Drawing",
    "- This program uses polymorphism to draw different shapes (Circle, Square) using a common interface.",
    "abstract class Shape {\n"
    + "    abstract void draw();\n"
    + "}\n"
    + "\n"
    + "class Circle extends Shape {\n"
    + "    void draw() {\n"
    + "        System.out.println(\"Drawing a circle.\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class Square extends Shape {\n"
    + "    void draw() {\n"
    + "        System.out.println(\"Drawing a square.\");\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class ShapeDemo {\n"
    + "    public static void main(String[] args) {\n"
    + "        Shape shape1 = new Circle();\n"
    + "        Shape shape2 = new Square();\n"
    + "\n"
    + "        shape1.draw();\n"
    + "        shape2.draw();\n"
    + "    }\n"
    + "}",
    "Drawing a circle.\n"
    + "Drawing a square."
));

projectsPanel.add(createProject(
    "100. Notification System",
    "- This program simulates a notification system where different notification types (Email, SMS) implement a common notification method.",
    "abstract class Notification {\n"
    + "    abstract void sendNotification(String message);\n"
    + "}\n"
    + "\n"
    + "class EmailNotification extends Notification {\n"
    + "    void sendNotification(String message) {\n"
    + "        System.out.println(\"Sending email notification: \" + message);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "class SMSNotification extends Notification {\n"
    + "    void sendNotification(String message) {\n"
    + "        System.out.println(\"Sending SMS notification: \" + message);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class NotificationDemo {\n"
    + "    public static void main(String[] args) {\n"
    + "        Notification email = new EmailNotification();\n"
    + "        Notification sms = new SMSNotification();\n"
    + "\n"
    + "        email.sendNotification(\"Hello, this is a test email.\");\n"
    + "        sms.sendNotification(\"Hello, this is a test SMS.\");\n"
    + "    }\n"
    + "}",
    "Sending email notification: Hello, this is a test email.\n"
    + "Sending SMS notification: Hello, this is a test SMS."
));

projectsPanel.add(createProject(
    "101. Bank Account Management",
    "- This project demonstrates encapsulation by creating a `BankAccount` class that encapsulates account details such as balance and account number. Public methods are provided for depositing and withdrawing funds.",
    "public class BankAccount {\n"
    + "    private String accountNumber;\n"
    + "    private double balance;\n"
    + "    \n"
    + "    public BankAccount(String accountNumber, double initialBalance) {\n"
    + "        this.accountNumber = accountNumber;\n"
    + "        this.balance = initialBalance;\n"
    + "    }\n"
    + "    \n"
    + "    public void deposit(double amount) {\n"
    + "        if (amount > 0) {\n"
    + "            balance += amount;\n"
    + "            System.out.println(\"Deposited: \" + amount);\n"
    + "        } else {\n"
    + "            System.out.println(\"Invalid deposit amount\");\n"
    + "        }\n"
    + "    }\n"
    + "    \n"
    + "    public void withdraw(double amount) {\n"
    + "        if (amount > 0 && amount <= balance) {\n"
    + "            balance -= amount;\n"
    + "            System.out.println(\"Withdrawn: \" + amount);\n"
    + "        } else {\n"
    + "            System.out.println(\"Invalid withdrawal amount\");\n"
    + "        }\n"
    + "    }\n"
    + "    \n"
    + "    public double getBalance() {\n"
    + "        return balance;\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        BankAccount account = new BankAccount(\"12345\", 1000.00);\n"
    + "        account.deposit(500);\n"
    + "        account.withdraw(200);\n"
    + "        System.out.println(\"Current Balance: \" + account.getBalance());\n"
    + "    }\n"
    + "}",
    "Deposited: 500.0\n"
    + "Withdrawn: 200.0\n"
    + "Current Balance: 1300.0"
));

projectsPanel.add(createProject(
    "102. Student Profile System",
    "- This project demonstrates encapsulation by creating a `Student` class with private attributes for name and age. Getter and setter methods are provided to safely access and modify these attributes.",
    "public class Student {\n"
    + "    private String name;\n"
    + "    private int age;\n"
    + "    \n"
    + "    public Student(String name, int age) {\n"
    + "        this.name = name;\n"
    + "        this.age = age;\n"
    + "    }\n"
    + "    \n"
    + "    public String getName() {\n"
    + "        return name;\n"
    + "    }\n"
    + "    \n"
    + "    public void setName(String name) {\n"
    + "        this.name = name;\n"
    + "    }\n"
    + "    \n"
    + "    public int getAge() {\n"
    + "        return age;\n"
    + "    }\n"
    + "    \n"
    + "    public void setAge(int age) {\n"
    + "        if (age > 0) {\n"
    + "            this.age = age;\n"
    + "        } else {\n"
    + "            System.out.println(\"Invalid age\");\n"
    + "        }\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Student student = new Student(\"Alice\", 20);\n"
    + "        System.out.println(\"Name: \" + student.getName() + \", Age: \" + student.getAge());\n"
    + "        student.setAge(21);\n"
    + "        System.out.println(\"Updated Age: \" + student.getAge());\n"
    + "    }\n"
    + "}",
    "Name: Alice, Age: 20\n"
    + "Updated Age: 21"
));

projectsPanel.add(createProject(
    "103. Car Information System",
    "- This project demonstrates encapsulation by creating a `Car` class that encapsulates details such as model, year, and price. Public methods are provided to display and update the car's information.",
    "public class Car {\n"
    + "    private String model;\n"
    + "    private int year;\n"
    + "    private double price;\n"
    + "    \n"
    + "    public Car(String model, int year, double price) {\n"
    + "        this.model = model;\n"
    + "        this.year = year;\n"
    + "        this.price = price;\n"
    + "    }\n"
    + "    \n"
    + "    public void displayInfo() {\n"
    + "        System.out.println(\"Model: \" + model + \", Year: \" + year + \", Price: \" + price);\n"
    + "    }\n"
    + "    \n"
    + "    public void setPrice(double price) {\n"
    + "        if (price > 0) {\n"
    + "            this.price = price;\n"
    + "        } else {\n"
    + "            System.out.println(\"Invalid price\");\n"
    + "        }\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Car car = new Car(\"Toyota Corolla\", 2020, 20000);\n"
    + "        car.displayInfo();\n"
    + "        car.setPrice(21000);\n"
    + "        System.out.println(\"Updated Info:\");\n"
    + "        car.displayInfo();\n"
    + "    }\n"
    + "}",
    "Model: Toyota Corolla, Year: 2020, Price: 20000.0\n"
    + "Updated Info:\n"
    + "Model: Toyota Corolla, Year: 2020, Price: 21000.0"
));

projectsPanel.add(createProject(
    "104. Product Management System",
    "- This project demonstrates encapsulation by creating a `Product` class that encapsulates product information such as name and price. Public methods are provided to get and set these values while ensuring data integrity.",
    "public class Product {\n"
    + "    private String name;\n"
    + "    private double price;\n"
    + "    \n"
    + "    public Product(String name, double price) {\n"
    + "        this.name = name;\n"
    + "        setPrice(price);\n"
    + "    }\n"
    + "    \n"
    + "    public String getName() {\n"
    + "        return name;\n"
    + "    }\n"
    + "    \n"
    + "    public double getPrice() {\n"
    + "        return price;\n"
    + "    }\n"
    + "    \n"
    + "    public void setPrice(double price) {\n"
    + "        if (price > 0) {\n"
    + "            this.price = price;\n"
    + "        } else {\n"
    + "            System.out.println(\"Invalid price\");\n"
    + "        }\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Product product = new Product(\"Laptop\", 1500);\n"
    + "        System.out.println(\"Product: \" + product.getName() + \", Price: \" + product.getPrice());\n"
    + "        product.setPrice(1600);\n"
    + "        System.out.println(\"Updated Price: \" + product.getPrice());\n"
    + "    }\n"
    + "}",
    "Product: Laptop, Price: 1500.0\n"
    + "Updated Price: 1600.0"
));

projectsPanel.add(createProject(
    "105. User Authentication System",
    "- This project demonstrates encapsulation by creating a `User` class with private attributes for username and password. Public methods are provided for registration and login while keeping sensitive data secure.",
    "public class User {\n"
    + "    private String username;\n"
    + "    private String password;\n"
    + "    \n"
    + "    public User(String username, String password) {\n"
    + "        this.username = username;\n"
    + "        setPassword(password);\n"
    + "    }\n"
    + "    \n"
    + "    public void setPassword(String password) {\n"
    + "        if (password.length() >= 6) {\n"
    + "            this.password = password;\n"
    + "        } else {\n"
    + "            System.out.println(\"Password must be at least 6 characters\");\n"
    + "        }\n"
    + "    }\n"
    + "    \n"
    + "    public boolean login(String username, String password) {\n"
    + "        return this.username.equals(username) && this.password.equals(password);\n"
    + "    }\n"
    + "}\n"
    + "\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        User user = new User(\"johnDoe\", \"securePassword\");\n"
    + "        if (user.login(\"johnDoe\", \"securePassword\")) {\n"
    + "            System.out.println(\"Login successful\");\n"
    + "        } else {\n"
    + "            System.out.println(\"Login failed\");\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Login successful"
));

projectsPanel.add(createProject(
    "106. Abstract Shape Class",
    "- This project demonstrates an abstract class `Shape` with abstract methods for calculating area and perimeter. Derived classes `Circle` and `Rectangle` provide specific implementations.",
    "abstract class Shape {\n"
    + "    abstract double area();\n"
    + "    abstract double perimeter();\n"
    + "}\n\n"
    + "class Circle extends Shape {\n"
    + "    private double radius;\n"
    + "    \n"
    + "    public Circle(double radius) {\n"
    + "        this.radius = radius;\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    double area() {\n"
    + "        return Math.PI * radius * radius;\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    double perimeter() {\n"
    + "        return 2 * Math.PI * radius;\n"
    + "    }\n"
    + "}\n\n"
    + "class Rectangle extends Shape {\n"
    + "    private double length, width;\n"
    + "    \n"
    + "    public Rectangle(double length, double width) {\n"
    + "        this.length = length;\n"
    + "        this.width = width;\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    double area() {\n"
    + "        return length * width;\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    double perimeter() {\n"
    + "        return 2 * (length + width);\n"
    + "    }\n"
    + "}\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Shape circle = new Circle(5);\n"
    + "        System.out.println(\"Circle Area: \" + circle.area());\n"
    + "        System.out.println(\"Circle Perimeter: \" + circle.perimeter());\n"
    + "        \n"
    + "        Shape rectangle = new Rectangle(4, 6);\n"
    + "        System.out.println(\"Rectangle Area: \" + rectangle.area());\n"
    + "        System.out.println(\"Rectangle Perimeter: \" + rectangle.perimeter());\n"
    + "    }\n"
    + "}",
    "Circle Area: 78.53981633974483\n"
    + "Circle Perimeter: 31.41592653589793\n"
    + "Rectangle Area: 24.0\n"
    + "Rectangle Perimeter: 20.0"
));

projectsPanel.add(createProject(
    "107. Abstract Vehicle Class",
    "- This project demonstrates an abstract class `Vehicle` with an abstract method `startEngine()`. Derived classes `Car`, `Motorcycle`, and `Truck` define how each type starts its engine.",
    "abstract class Vehicle {\n"
    + "    abstract void startEngine();\n"
    + "}\n\n"
    + "class Car extends Vehicle {\n"
    + "    @Override\n"
    + "    void startEngine() {\n"
    + "        System.out.println(\"Car engine started.\");\n"
    + "    }\n"
    + "}\n\n"
    + "class Motorcycle extends Vehicle {\n"
    + "    @Override\n"
    + "    void startEngine() {\n"
    + "        System.out.println(\"Motorcycle engine started.\");\n"
    + "    }\n"
    + "}\n\n"
    + "class Truck extends Vehicle {\n"
    + "    @Override\n"
    + "    void startEngine() {\n"
    + "        System.out.println(\"Truck engine started.\");\n"
    + "    }\n"
    + "}\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Vehicle car = new Car();\n"
    + "        car.startEngine();\n"
    + "        \n"
    + "        Vehicle motorcycle = new Motorcycle();\n"
    + "        motorcycle.startEngine();\n"
    + "        \n"
    + "        Vehicle truck = new Truck();\n"
    + "        truck.startEngine();\n"
    + "    }\n"
    + "}",
    "Car engine started.\n"
    + "Motorcycle engine started.\n"
    + "Truck engine started."
));

projectsPanel.add(createProject(
    "108. Game Characters",
    "- This project creates an abstract class `Character` with abstract methods for `attack()` and `defend()`. Derived classes `Warrior`, `Mage`, and `Archer` provide specific implementations.",
    "abstract class Character {\n"
    + "    abstract void attack();\n"
    + "    abstract void defend();\n"
    + "}\n\n"
    + "class Warrior extends Character {\n"
    + "    @Override\n"
    + "    void attack() {\n"
    + "        System.out.println(\"Warrior attacks with sword!\");\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    void defend() {\n"
    + "        System.out.println(\"Warrior defends with shield!\");\n"
    + "    }\n"
    + "}\n\n"
    + "class Mage extends Character {\n"
    + "    @Override\n"
    + "    void attack() {\n"
    + "        System.out.println(\"Mage casts a fireball!\");\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    void defend() {\n"
    + "        System.out.println(\"Mage uses a magic shield!\");\n"
    + "    }\n"
    + "}\n\n"
    + "class Archer extends Character {\n"
    + "    @Override\n"
    + "    void attack() {\n"
    + "        System.out.println(\"Archer shoots an arrow!\");\n"
    + "    }\n"
    + "    \n"
    + "    @Override\n"
    + "    void defend() {\n"
    + "        System.out.println(\"Archer dodges the attack!\");\n"
    + "    }\n"
    + "}\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Character warrior = new Warrior();\n"
    + "        warrior.attack();\n"
    + "        warrior.defend();\n"
    + "        \n"
    + "        Character mage = new Mage();\n"
    + "        mage.attack();\n"
    + "        mage.defend();\n"
    + "        \n"
    + "        Character archer = new Archer();\n"
    + "        archer.attack();\n"
    + "        archer.defend();\n"
    + "    }\n"
    + "}",
    "Warrior attacks with sword!\n"
    + "Warrior defends with shield!\n"
    + "Mage casts a fireball!\n"
    + "Mage uses a magic shield!\n"
    + "Archer shoots an arrow!\n"
    + "Archer dodges the attack!"
));

projectsPanel.add(createProject(
    "109. Payment Processing",
    "- This project creates an abstract class `Payment` with an abstract method `processPayment()`. Derived classes `CreditCardPayment` and `PayPalPayment` define specific payment processing methods.",
    "abstract class Payment {\n"
    + "    abstract void processPayment();\n"
    + "}\n\n"
    + "class CreditCardPayment extends Payment {\n"
    + "    @Override\n"
    + "    void processPayment() {\n"
    + "        System.out.println(\"Processing credit card payment...\");\n"
    + "    }\n"
    + "}\n\n"
    + "class PayPalPayment extends Payment {\n"
    + "    @Override\n"
    + "    void processPayment() {\n"
    + "        System.out.println(\"Processing PayPal payment...\");\n"
    + "    }\n"
    + "}\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Payment payment1 = new CreditCardPayment();\n"
    + "        payment1.processPayment();\n"
    + "        \n"
    + "        Payment payment2 = new PayPalPayment();\n"
    + "        payment2.processPayment();\n"
    + "    }\n"
    + "}",
    "Processing credit card payment...\n"
    + "Processing PayPal payment..."
));

projectsPanel.add(createProject(
    "110. Abstract Animal Class",
    "- This project demonstrates an abstract class `Animal` with an abstract method `makeSound()`. Derived classes `Dog` and `Cat` implement the sound each animal makes.",
    "abstract class Animal {\n"
    + "    abstract void makeSound();\n"
    + "}\n\n"
    + "class Dog extends Animal {\n"
    + "    @Override\n"
    + "    void makeSound() {\n"
    + "        System.out.println(\"Woof!\");\n"
    + "    }\n"
    + "}\n\n"
    + "class Cat extends Animal {\n"
    + "    @Override\n"
    + "    void makeSound() {\n"
    + "        System.out.println(\"Meow!\");\n"
    + "    }\n"
    + "}\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Animal dog = new Dog();\n"
    + "        dog.makeSound();\n"
    + "        \n"
    + "        Animal cat = new Cat();\n"
    + "        cat.makeSound();\n"
    + "    }\n"
    + "}",
    "Woof!\n"
    + "Meow!"
));

projectsPanel.add(createProject(
    "111. Basic User Input",
    "- This project prompts the user to enter their name and then greets them.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter your name: \");\n"
    + "        String name = scanner.nextLine();\n"
    + "        System.out.println(\"Hello, \" + name + \"!\");\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "112. Simple Calculator",
    "- This project takes two numbers and an operator (+, -, *, /) from the user and performs the corresponding operation.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter first number: \");\n"
    + "        double num1 = scanner.nextDouble();\n"
    + "        System.out.print(\"Enter second number: \");\n"
    + "        double num2 = scanner.nextDouble();\n"
    + "        System.out.print(\"Enter operator (+, -, *, /): \");\n"
    + "        char operator = scanner.next().charAt(0);\n"
    + "        double result;\n"
    + "        switch (operator) {\n"
    + "            case '+':\n"
    + "                result = num1 + num2;\n"
    + "                break;\n"
    + "            case '-':\n"
    + "                result = num1 - num2;\n"
    + "                break;\n"
    + "            case '*':\n"
    + "                result = num1 * num2;\n"
    + "                break;\n"
    + "            case '/':\n"
    + "                result = num1 / num2;\n"
    + "                break;\n"
    + "            default:\n"
    + "                System.out.println(\"Invalid operator\");\n"
    + "                return;\n"
    + "        }\n"
    + "        System.out.println(\"Result: \" + result);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "113. Odd or Even",
    "- This project checks whether a number entered by the user is odd or even.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        if (number % 2 == 0) {\n"
    + "            System.out.println(number + \" is even.\");\n"
    + "        } else {\n"
    + "            System.out.println(number + \" is odd.\");\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "114. Factorial Calculation",
    "- This project calculates the factorial of a number entered by the user using a loop.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a positive integer: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        long factorial = 1;\n"
    + "        for (int i = 1; i <= number; i++) {\n"
    + "            factorial *= i;\n"
    + "        }\n"
    + "        System.out.println(\"Factorial of \" + number + \" is: \" + factorial);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "115. Sum of Numbers",
    "- This project calculates the sum of numbers entered by the user until they enter 0.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        int sum = 0;\n"
    + "        int number;\n"
    + "        do {\n"
    + "            System.out.print(\"Enter a number (0 to stop): \");\n"
    + "            number = scanner.nextInt();\n"
    + "            sum += number;\n"
    + "        } while (number != 0);\n"
    + "        System.out.println(\"Sum of numbers: \" + sum);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "116. Multiplication Table",
    "- This project prints the multiplication table for a number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        for (int i = 1; i <= 10; i++) {\n"
    + "            System.out.println(number + \" x \" + i + \" = \" + (number * i));\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "117. Reverse a Number",
    "- This project reverses the digits of a number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        int reversed = 0;\n"
    + "        while (number != 0) {\n"
    + "            int digit = number % 10;\n"
    + "            reversed = reversed * 10 + digit;\n"
    + "            number /= 10;\n"
    + "        }\n"
    + "        System.out.println(\"Reversed number: \" + reversed);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "118. Fibonacci Series",
    "- This project prints the Fibonacci series up to a number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter the limit: \");\n"
    + "        int limit = scanner.nextInt();\n"
    + "        int a = 0, b = 1;\n"
    + "        System.out.print(\"Fibonacci Series: \" + a + \" \" + b);\n"
    + "        for (int i = 2; i < limit; i++) {\n"
    + "            int next = a + b;\n"
    + "            System.out.print(\" \" + next);\n"
    + "            a = b;\n"
    + "            b = next;\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "119. Prime Number Checker",
    "- This project checks whether a number entered by the user is prime.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        boolean isPrime = true;\n"
    + "        if (number <= 1) {\n"
    + "            isPrime = false;\n"
    + "        } else {\n"
    + "            for (int i = 2; i <= Math.sqrt(number); i++) {\n"
    + "                if (number % i == 0) {\n"
    + "                    isPrime = false;\n"
    + "                    break;\n"
    + "                }\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(number + (isPrime ? \" is a prime number.\" : \" is not a prime number.\"));\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "120. Count Digits in a Number",
    "- This project counts the number of digits in a number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        int count = 0;\n"
    + "        while (number != 0) {\n"
    + "            number /= 10;\n"
    + "            count++;\n"
    + "        }\n"
    + "        System.out.println(\"Number of digits: \" + count);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "121. Palindrome Checker",
    "- This project checks if a number entered by the user is a palindrome.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        int original = number;\n"
    + "        int reversed = 0;\n"
    + "        while (number != 0) {\n"
    + "            int digit = number % 10;\n"
    + "            reversed = reversed * 10 + digit;\n"
    + "            number /= 10;\n"
    + "        }\n"
    + "        System.out.println(original + (original == reversed ? \" is a palindrome.\" : \" is not a palindrome.\"));\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "122. Count Vowels in a String",
    "- This project counts the number of vowels in a string entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a string: \");\n"
    + "        String input = scanner.nextLine();\n"
    + "        int count = 0;\n"
    + "        for (char c : input.toCharArray()) {\n"
    + "            if (\"AEIOUaeiou\".indexOf(c) != -1) {\n"
    + "                count++;\n"
    + "            }\n"
    + "        }\n"
    + "        System.out.println(\"Number of vowels: \" + count);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "123. Reverse a String",
    "- This project reverses a string entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a string: \");\n"
    + "        String input = scanner.nextLine();\n"
    + "        String reversed = new StringBuilder(input).reverse().toString();\n"
    + "        System.out.println(\"Reversed string: \" + reversed);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "124. Character Frequency",
    "- This project counts the frequency of each character in a string entered by the user.",
    "import java.util.HashMap;\n"
    + "import java.util.Map;\n"
    + "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a string: \");\n"
    + "        String input = scanner.nextLine();\n"
    + "        Map<Character, Integer> frequencyMap = new HashMap<>();\n"
    + "        for (char c : input.toCharArray()) {\n"
    + "            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);\n"
    + "        }\n"
    + "        System.out.println(\"Character frequencies: \" + frequencyMap);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "125. Simple Voting System",
    "- This project allows users to vote for their favorite option and displays the result.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        int option1Votes = 0;\n"
    + "        int option2Votes = 0;\n"
    + "        int vote;\n"
    + "        do {\n"
    + "            System.out.print(\"Vote for option 1 or 2 (0 to stop): \");\n"
    + "            vote = scanner.nextInt();\n"
    + "            if (vote == 1) {\n"
    + "                option1Votes++;\n"
    + "            } else if (vote == 2) {\n"
    + "                option2Votes++;\n"
    + "            }\n"
    + "        } while (vote != 0);\n"
    + "        System.out.println(\"Option 1 votes: \" + option1Votes);\n"
    + "        System.out.println(\"Option 2 votes: \" + option2Votes);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "126. Guess the Number",
    "- This project generates a random number and allows the user to guess it.",
    "import java.util.Random;\n"
    + "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Random random = new Random();\n"
    + "        int randomNumber = random.nextInt(100) + 1;\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        int guess;\n"
    + "        do {\n"
    + "            System.out.print(\"Guess the number (1-100): \");\n"
    + "            guess = scanner.nextInt();\n"
    + "            if (guess < randomNumber) {\n"
    + "                System.out.println(\"Too low!\");\n"
    + "            } else if (guess > randomNumber) {\n"
    + "                System.out.println(\"Too high!\");\n"
    + "            }\n"
    + "        } while (guess != randomNumber);\n"
    + "        System.out.println(\"Correct! The number was \" + randomNumber);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "127. Simple ATM",
    "- This project simulates a simple ATM where users can check balance, deposit, and withdraw.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        double balance = 1000.00;\n"
    + "        int choice;\n"
    + "        do {\n"
    + "            System.out.println(\"1. Check Balance\");\n"
    + "            System.out.println(\"2. Deposit\");\n"
    + "            System.out.println(\"3. Withdraw\");\n"
    + "            System.out.println(\"0. Exit\");\n"
    + "            System.out.print(\"Choose an option: \");\n"
    + "            choice = scanner.nextInt();\n"
    + "            switch (choice) {\n"
    + "                case 1:\n"
    + "                    System.out.println(\"Current balance: \" + balance);\n"
    + "                    break;\n"
    + "                case 2:\n"
    + "                    System.out.print(\"Enter amount to deposit: \");\n"
    + "                    double deposit = scanner.nextDouble();\n"
    + "                    balance += deposit;\n"
    + "                    break;\n"
    + "                case 3:\n"
    + "                    System.out.print(\"Enter amount to withdraw: \");\n"
    + "                    double withdraw = scanner.nextDouble();\n"
    + "                    if (withdraw <= balance) {\n"
    + "                        balance -= withdraw;\n"
    + "                    } else {\n"
    + "                        System.out.println(\"Insufficient balance.\");\n"
    + "                    }\n"
    + "                    break;\n"
    + "                case 0:\n"
    + "                    System.out.println(\"Exiting...\");\n"
    + "                    break;\n"
    + "                default:\n"
    + "                    System.out.println(\"Invalid choice.\");\n"
    + "                    break;\n"
    + "            }\n"
    + "        } while (choice != 0);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "128. Simple Calculator",
    "- This project implements a basic calculator that performs addition, subtraction, multiplication, and division.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter first number: \");\n"
    + "        double num1 = scanner.nextDouble();\n"
    + "        System.out.print(\"Enter second number: \");\n"
    + "        double num2 = scanner.nextDouble();\n"
    + "        System.out.print(\"Enter operation (+, -, *, /): \");\n"
    + "        char operation = scanner.next().charAt(0);\n"
    + "        double result;\n"
    + "        switch (operation) {\n"
    + "            case '+':\n"
    + "                result = num1 + num2;\n"
    + "                break;\n"
    + "            case '-':\n"
    + "                result = num1 - num2;\n"
    + "                break;\n"
    + "            case '*':\n"
    + "                result = num1 * num2;\n"
    + "                break;\n"
    + "            case '/':\n"
    + "                result = num2 != 0 ? num1 / num2 : Double.NaN;\n"
    + "                break;\n"
    + "            default:\n"
    + "                System.out.println(\"Invalid operation\");\n"
    + "                return;\n"
    + "        }\n"
    + "        System.out.println(\"Result: \" + result);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "129. Fibonacci Series",
    "- This project generates the Fibonacci series up to a certain number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter the number of terms: \");\n"
    + "        int n = scanner.nextInt();\n"
    + "        int a = 0, b = 1;\n"
    + "        System.out.print(\"Fibonacci Series: \" + a + \", \" + b);\n"
    + "        for (int i = 2; i < n; i++) {\n"
    + "            int next = a + b;\n"
    + "            System.out.print(\", \" + next);\n"
    + "            a = b;\n"
    + "            b = next;\n"
    + "        }\n"
    + "    }\n"
    + "}",
    "Input not supported"
));

projectsPanel.add(createProject(
    "130. Factorial Calculator",
    "- This project calculates the factorial of a number entered by the user.",
    "import java.util.Scanner;\n\n"
    + "public class Main {\n"
    + "    public static void main(String[] args) {\n"
    + "        Scanner scanner = new Scanner(System.in);\n"
    + "        System.out.print(\"Enter a number: \");\n"
    + "        int number = scanner.nextInt();\n"
    + "        int factorial = 1;\n"
    + "        for (int i = 1; i <= number; i++) {\n"
    + "            factorial *= i;\n"
    + "        }\n"
    + "        System.out.println(\"Factorial of \" + number + \" is: \" + factorial);\n"
    + "    }\n"
    + "}",
    "Input not supported"
));




















    return projectsPanel;
}

    // Creating the Contact section
    private JPanel createContactPanel() {
    JPanel contactPanel = new JPanel();
    contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.Y_AXIS));
    contactPanel.setBackground(new Color(44, 47, 51));

    JLabel title = new JLabel("Contact");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(Color.WHITE);

    String content = "Here is the contact information of the owner of this portfolio.\n\n"
            + "Owner:\n"
            + "Name: Yisrael Wyatt Castañares\n"
            + "Email: wyattcastanares@gmail.com\n"
            + "Contact Number : +1234567890\n"
            + "Facebook : www.facebook.com/AhrkeModeux?mibextid=ZbWKwL\n\n"
            + "Co-Owner:\n"
            + "Name: Name\n"
            + "Email: name@gmail.com\n"
            + "Contact Number: +0987654321\n"
            + "Facebook: facebook.com/name";

    contactPanel.add(title);
    contactPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    contactPanel.add(createTextBox(content));

    return contactPanel;
}


    // Creating the Our Knowledge section
  private JPanel createKnowledgePanel() {
    JPanel knowledgePanel = new JPanel();
    knowledgePanel.setLayout(new BoxLayout(knowledgePanel, BoxLayout.Y_AXIS));
    knowledgePanel.setBackground(new Color(44, 47, 51));

    JLabel title = new JLabel("<html><span style='font-family: Poppins; font-size: 28px; color: white;'>" + 
        "Our Knowledge</span></html>");
    title.setHorizontalAlignment(SwingConstants.CENTER);

JEditorPane contentArea = new JEditorPane(); // Change JTextArea to JEditorPane
    contentArea.setContentType("text/html"); // Set content type to HTML
    contentArea.setFont(new Font("Poppins", Font.PLAIN, 16)); // Use Poppins font for the content
    contentArea.setForeground(Color.WHITE);
    contentArea.setBackground(new Color(44, 47, 51)); // Match panel background color
    contentArea.setEditable(false); // Make the text area non-editable
    contentArea.setOpaque(false); // Make the text area transparent
    contentArea.setBorder(BorderFactory.createEmptyBorder()); // Remove border

    // Add sections with headings and bullet points
    StringBuilder content = new StringBuilder();

content.append("<html>"); // Start HTML formatting for text area

    // Append your provided content
    content.append("<span style='font-family: Poppins; font-size: 16px; color: white;'>");
    content.append("Introduction to Java<br><br>");
    content.append("In our journey to learn Java, we discovered that it is a widely-used, high-level programming language known for its platform independence, security features, and robust performance. Developed by Sun Microsystems (now owned by Oracle Corporation), Java was designed to be simple, portable, and efficient. One of the key takeaways was its 'Write Once, Run Anywhere' (WORA) capability, which allows Java code to run on any device equipped with a Java Virtual Machine (JVM). This feature significantly enhances Java’s appeal in a diverse range of applications, from mobile devices to enterprise-level applications.<br><br>");

    content.append("<strong>Basics of Java</strong><br><br>");
    content.append("Before diving into coding, we focused on understanding some basic concepts that form the foundation of Java programming.<br><br>");

        content.append("<strong>Data Types</strong><br>");
content.append("As we delved deeper, we explored various data types supported by Java. These data types are categorized into two groups:<br><br>");

content.append("<ul>");
content.append("<li><strong>Primitive Types</strong>: These include basic types like <code>int</code> (for integers), <code>char</code> (for characters), <code>boolean</code> (for true/false values), and <code>double</code> (for decimal numbers). For instance, we learned how to declare variables of these types:<br><br>");
content.append("<pre>int age = 25;<br>char initial = 'A';<br>boolean isStudent = true;<br>double height = 5.9;</pre></li>");
content.append("<li><strong>Reference Types</strong>: These are more complex data types, such as arrays and objects. For example, we created a string object:<br><br>");
content.append("<pre>String name = \"John Doe\";</pre></li>");
content.append("</ul><br>");

content.append("<strong>Variables</strong><br>");
content.append("We understood that variables in Java are containers for storing data and must be declared with a specific data type before use. We learned how to initialize variables and how the scope of a variable can affect its accessibility within different parts of our code.<br><br>");

        
content.append("<strong>Creating a Project in NetBeans</strong><br>");
content.append("In our practical sessions, we used NetBeans, an Integrated Development Environment (IDE) that simplifies Java development. Here’s a step-by-step guide on how we created a new Java project:<br><br>");

content.append("<ol>");
content.append("<li><strong>Install NetBeans</strong>: We started by downloading and installing the latest version of NetBeans IDE from the official website, ensuring we had all the necessary tools at our disposal.</li>");
content.append("<li><strong>Launch NetBeans</strong>: After installation, we opened the IDE, which greeted us with a user-friendly interface designed for coding.</li>");
content.append("<li><strong>Create a New Project</strong>:<br>We clicked on <code>File</code> > <code>New Project</code>.<br>Selected <code>Java</code> under Categories, and then chose <code>Java Application</code>.<br>Clicked <code>Next</code> to proceed.</li>");
content.append("<li><strong>Project Details</strong>:<br>We entered a project name, such as <code>MyFirstJavaProject</code>, and chose a suitable location for our project files.<br>If desired, we unchecked <code>Create Main Class</code> to manually create our classes later.<br>Clicked <code>Finish</code> to complete the project setup.</li>");
content.append("<li><strong>Writing Code</strong>: Once the project was created, we started writing our Java code in the editor. We learned how to create new classes by right-clicking on the <code>Source Packages</code> folder, selecting <code>New</code>, and then <code>Java Class</code>. This hands-on experience allowed us to become familiar with the IDE's features, such as code highlighting, auto-completion, and debugging tools.</li>");
content.append("</ol><br>");

content.append("<strong>Concatenation in Java</strong><br>");
content.append("One of the essential concepts we learned was concatenation, which is the process of joining two or more strings together. In Java, we can achieve this using the <code>+</code> operator. Here’s an example:<br><br>");
content.append("<pre>String firstName = \"John\";<br>String lastName = \"Doe\";<br>String fullName = firstName + \" \" + lastName; // Concatenates firstName and lastName<br>System.out.println(fullName); // Output: John Doe</pre><br>");
content.append("Through practical exercises, we discovered that we could concatenate not just strings, but also strings with other data types by converting them to strings first. For instance:<br><br>");
content.append("<pre>int age = 30;<br>String message = \"My name is \" + fullName + \" and I am \" + age + \" years old.\";<br>System.out.println(message);</pre><br>");

content.append("<strong>Operators in Java</strong><br>");
content.append("We discovered that Java supports several types of operators that are essential for performing various operations on data.<br><br>");

content.append("<strong>Arithmetic Operators</strong><br>");
content.append("We learned that arithmetic operators are used for performing mathematical calculations, such as addition, subtraction, multiplication, and division. Here are the basic arithmetic operators:<br><br>");

content.append("<ul>");
content.append("<li><code>+</code> (addition)</li>");
content.append("<li><code>-</code> (subtraction)</li>");
content.append("<li><code>*</code> (multiplication)</li>");
content.append("<li><code>/</code> (division)</li>");
content.append("<li><code>%</code> (modulus)</li>");
content.append("</ul><br>");

content.append("For example:<br><br>");
content.append("<pre>int a = 10;<br>int b = 5;<br>int sum = a + b; // 15<br>int product = a * b; // 50<br>int remainder = a % b; // 0</pre><br>");

content.append("<strong>Relational Operators</strong><br>");
content.append("Relational operators allow us to compare two values and return a boolean result (true or false). We learned the following relational operators:<br><br>");

content.append("<ul>");
content.append("<li><code>==</code> (equal to)</li>");
content.append("<li><code>!=</code> (not equal to)</li>");
content.append("<li><code>></code> (greater than)</li>");
content.append("<li><code><</code> (less than)</li>");
content.append("<li><code>>=</code> (greater than or equal to)</li>");
content.append("<li><code><=</code> (less than or equal to)</li>");
content.append("</ul><br>");

content.append("An example would be:<br><br>");
content.append("<pre>boolean isEqual = (a == b); // false<br>boolean isGreater = (a > b); // true</pre><br>");

content.append("<strong>Logical Operators</strong><br>");
content.append("Logical operators are used to combine two or more boolean expressions. We learned about:<br><br>");

content.append("<ul>");
content.append("<li><code>&&</code> (logical AND)</li>");
content.append("<li><code>||</code> (logical OR)</li>");
content.append("<li><code>!</code> (logical NOT)</li>");
content.append("</ul><br>");

content.append("For instance:<br><br>");
content.append("<pre>boolean condition1 = (a > b); // true<br>boolean condition2 = (a < 15); // true<br>boolean result = condition1 && condition2; // true</pre><br>");

content.append("<h3>Assignment Operators</h3>");
content.append("We also explored assignment operators, which are used to assign values to variables. The most common is the `=` operator, but there are others that combine arithmetic operations with assignment:<br><br>");

content.append("- `+=` (add and assign)<br>");
content.append("- `-=` (subtract and assign)<br>");
content.append("- `*=` (multiply and assign)<br>");
content.append("- `/=` (divide and assign)<br>");
content.append("- `%=` (modulus and assign)<br><br>");

content.append("For example:<br><br>");
content.append("<code>int c = 10;<br>c += 5; // c is now 15</code><br><br>");

content.append("<h3>Conditions in Java</h3>");
content.append("As we progressed, we learned how to use conditional statements in Java to execute different actions based on specific conditions.<br><br>");

content.append("<h4>If-Else Statements</h4>");
content.append("The if-else statement allows us to execute a block of code based on whether a condition is true or false. Here’s an example:<br><br>");
content.append("<code>int score = 85;<br>if (score >= 90) {<br>    System.out.println(\"Grade: A\");<br>} else if (score >= 80) {<br>    System.out.println(\"Grade: B\");<br>} else {<br>    System.out.println(\"Grade: C\");<br>}</code><br><br>");

content.append("Through practical exercises, we learned how to evaluate multiple conditions using else-if statements, enhancing our ability to make decisions within our code.<br><br>");

content.append("<h4>Nested If Statements</h4>");
content.append("We explored nested if statements, which allow us to place one if statement inside another. This structure is useful for checking multiple conditions:<br><br>");
content.append("<code>int number = 10;<br>if (number > 0) {<br>    System.out.println(\"Positive Number\");<br>    if (number % 2 == 0) {<br>        System.out.println(\"Even Number\");<br>    } else {<br>        System.out.println(\"Odd Number\");<br>    }<br>}</code><br><br>");

content.append("<h4>Switch Case</h4>");
content.append("We also learned about the switch statement as another way to execute different code based on a variable's value. It’s particularly useful when dealing with multiple discrete values.<br><br>");
content.append("<code>int day = 3;<br>switch (day) {<br>    case 1:<br>        System.out.println(\"Monday\");<br>        break;<br>    case 2:<br>        System.out.println(\"Tuesday\");<br>        break;<br>    case 3:<br>        System.out.println(\"Wednesday\");<br>        break;<br>    default:<br>        System.out.println(\"Invalid Day\");<br>}</code><br><br>");

content.append("We practiced using switch statements for various scenarios, allowing us to streamline decision-making processes in our code.<br><br>");
        
        content.append("<h3>Loops in Java</h3>");
content.append("In our exploration of loops, we understood that they are used to execute a block of code repeatedly until a specified condition is met. We found this extremely useful for tasks that require iteration.<br><br>");

content.append("<h4>For Loop</h4>");
content.append("The for loop is a control flow statement that allows us to execute a block of code a specific number of times. Here’s the basic structure:<br><br>");
content.append("<code>for (int i = 0; i < 5; i++) {<br>    System.out.println(\"Count: \" + i);<br>}</code><br><br>");

content.append("This loop initializes `i` to 0, checks the condition `i < 5`, and increments `i` by 1 after each iteration. We used for loops extensively to iterate over arrays and collections.<br><br>");

content.append("<h4>While Loop</h4>");
content.append("We learned that the while loop continues to execute as long as a specified condition is true. Here's how it looks:<br><br>");
content.append("<code>int count = 0;<br>while (count < 5) {<br>    System.out.println(\"Count: \" + count);<br>    count++;<br>}</code><br><br>");

content.append("This loop allowed us to execute code as long as the count was less than 5, demonstrating the concept of indefinite iteration.<br><br>");

content.append("<h4>Do-While Loop</h4>");
content.append("The do-while loop is similar to the while loop, but it guarantees that the code block will execute at least once before checking the condition. Its syntax is as follows:<br><br>");
content.append("<code>int num = 0;<br>do {<br>    System.out.println(\"Number: \" + num);<br>    num++;<br>} while (num < 5);</code><br><br>");

content.append("We found do-while loops useful in scenarios where we needed the loop to execute at least once, such as user input prompts.<br><br>");


content.append("<h3>Arrays in Java</h3>");
content.append("We discovered arrays as a way to store multiple values in a single variable, which can be particularly useful when handling large amounts of data.<br><br>");

content.append("<h4>One-Dimensional Arrays</h4>");
content.append("One-dimensional arrays are simple lists of elements. We learned to declare, initialize, and access elements in a one-dimensional array like this:<br><br>");
content.append("<code>int[] numbers = {1, 2, 3, 4, 5};<br>System.out.println(numbers[0]); // Output: 1</code><br><br>");

content.append("<h4>Two-Dimensional Arrays</h4>");
content.append("Two-dimensional arrays are essentially arrays of arrays, allowing us to create a matrix-like structure. We learned how to declare and manipulate 2D arrays:<br><br>");
content.append("<code>int[][] matrix = {<br>    {1, 2, 3},<br>    {4, 5, 6},<br>    {7, 8, 9}<br>};<br>System.out.println(matrix[1][2]); // Output: 6</code><br><br>");

content.append("<h4>Three-Dimensional Arrays</h4>");
content.append("Three-dimensional arrays take this concept further, adding another layer of depth. Although less common, we explored their usage:<br><br>");
content.append("<code>int[][][] cube = {<br>    {<br>        {1, 2},<br>        {3, 4}<br>    },<br>    {<br>        {5, 6},<br>        {7, 8}<br>    }<br>};<br>System.out.println(cube[1][0][1]); // Output: 6</code><br><br>");

content.append("This multi-dimensional structure opened our minds to the power of arrays in organizing and processing complex data.<br><br>");

content.append("<h3>Scanners in Java</h3>");
content.append("We learned about the `Scanner` class, which is part of the `java.util` package and allows us to obtain input from various sources, including user input from the console.<br><br>");

content.append("To use the `Scanner`, we first import the package:<br><br>");
content.append("<code>import java.util.Scanner;</code><br><br>");

content.append("Then we create a `Scanner` object and read input:<br><br>");
content.append("<code>Scanner scanner = new Scanner(System.in);<br>System.out.print(\"Enter your name: \");<br>String name = scanner.nextLine();<br>System.out.println(\"Hello, \" + name + \"!\");</code><br><br>");

content.append("This interactive capability enabled us to create more dynamic programs that respond to user input.<br><br>");

content.append("<h3>Packages in Java</h3>");
content.append("As our projects grew, we learned about Java packages, which are used to group related classes and interfaces. This organization helps manage large projects and avoid name conflicts.<br><br>");

content.append("We discovered how to create a package and use it in our Java programs:<br><br>");
content.append("<code>package mypackage;<br><br>public class MyClass {<br>    public void display() {<br>        System.out.println(\"Hello from MyClass in mypackage!\");<br>    }<br>}</code><br><br>");

content.append("To use the `MyClass` from another class, we simply import the package:<br><br>");
content.append("<code>import mypackage.MyClass;<br><br>public class Test {<br>    public static void main(String[] args) {<br>        MyClass obj = new MyClass();<br>        obj.display();<br>    }<br>}</code><br><br>");

content.append("This modular approach allowed us to maintain clean and organized code.<br><br>");

content.append("<strong>Methods in Java</strong><br>");
content.append("We learned that methods are blocks of code designed to perform specific tasks. They help us to write reusable and organized code. We discovered how to define and call methods:<br><br>");

content.append("<strong>Defining a Method</strong><br>");
content.append("<code>public static void greet(String name) {<br>");
content.append("    System.out.println(\"Hello, \" + name + \"!\");<br>");
content.append("}</code><br><br>");

content.append("<strong>Calling a Method</strong><br>");
content.append("<code>public static void main(String[] args) {<br>");
content.append("    greet(\"Alice\"); // Output: Hello, Alice!<br>");
content.append("}</code><br><br>");

content.append("We also learned about method overloading, where we can define multiple methods with the same name but different parameters:<br><br>");
content.append("<code>public static int add(int a, int b) {<br>");
content.append("    return a + b;<br>");
content.append("}<br><br>");
content.append("public static double add(double a, double b) {<br>");
content.append("    return a + b;<br>");
content.append("}</code><br><br>");

content.append("<strong>Object-Oriented Programming (OOP) in Java</strong><br>");
content.append("As we explored Java further, we realized it is fundamentally an object-oriented programming language. This paradigm is based on four main principles: Encapsulation, Inheritance, Polymorphism, and Abstraction.<br><br>");

content.append("<strong>1. Encapsulation</strong><br>");
content.append("We learned that encapsulation is the practice of wrapping data (variables) and methods into a single unit called a class. It allows us to control access to the data through access modifiers (public, private, protected). By using getters and setters, we can protect our data while providing controlled access:<br><br>");
content.append("<code>public class Person {<br>");
content.append("    private String name;<br><br>");
content.append("    public String getName() {<br>");
content.append("        return name;<br>");
content.append("    }<br><br>");
content.append("    public void setName(String name) {<br>");
content.append("        this.name = name;<br>");
content.append("    }<br>");
content.append("}</code><br><br>");

content.append("<strong>2. Inheritance</strong><br>");
content.append("Inheritance allows a new class to inherit the properties and methods of an existing class. This promotes code reusability. We learned how to create a subclass:<br><br>");
content.append("<code>class Animal {<br>");
content.append("    void eat() {<br>");
content.append("        System.out.println(\"Animal is eating.\");<br>");
content.append("    }<br>");
content.append("}<br><br>");
content.append("class Dog extends Animal {<br>");
content.append("    void bark() {<br>");
content.append("        System.out.println(\"Dog is barking.\");<br>");
content.append("    }<br>");
content.append("}</code><br><br>");

content.append("<strong>3. Polymorphism</strong><br>");
content.append("Polymorphism allows us to perform a single action in different ways. We learned about method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.<br><br>");
content.append("<code>@Override<br>");
content.append("public void eat() {<br>");
content.append("    System.out.println(\"Dog is eating.\");<br>");
content.append("}</code><br><br>");
content.append("We also explored method overloading as a form of compile-time polymorphism.<br><br>");

content.append("<strong>4. Abstraction</strong><br>");
content.append("We learned that abstraction is the concept of hiding complex realities while exposing only the necessary parts. In Java, we achieve abstraction using abstract classes and interfaces.<br><br>");

content.append("<strong>Abstract Class</strong>: Cannot be instantiated but can have abstract methods.<br><br>");
content.append("<code>abstract class Shape {<br>");
content.append("    abstract void draw();<br>");
content.append("}<br><br>");
content.append("class Circle extends Shape {<br>");
content.append("    void draw() {<br>");
content.append("        System.out.println(\"Drawing Circle\");<br>");
content.append("    }<br>");
content.append("}</code><br><br>");

content.append("<strong>Interface</strong>: Contains abstract methods that must be implemented by subclasses.<br><br>");
content.append("<code>interface Animal {<br>");
content.append("    void eat();<br>");
content.append("}<br><br>");
content.append("class Cat implements Animal {<br>");
content.append("    public void eat() {<br>");
content.append("        System.out.println(\"Cat is eating.\");<br>");
content.append("    }<br>");
content.append("}</code><br><br>");

content.append("Through our understanding of OOP principles, we were able to design our programs in a more structured and modular way, leading to better maintainability and scalability.<br><br>");

content.append("<strong>Conclusion</strong><br>");
content.append("Throughout our studies, we found that Java is a versatile and powerful programming language that forms the backbone of many applications, from web development to enterprise solutions. By understanding its fundamentals, including syntax, data types, control structures, and object-oriented programming principles, we have equipped ourselves with the knowledge needed to create robust and efficient applications. Using tools like NetBeans and leveraging Java's rich set of features, we are now capable of tackling various programming challenges with confidence. Our journey into Java has not only enhanced our coding skills but has also broadened our understanding of software development as a whole.<br><br>");

    
     
content.append("</span>"); // Closing span for content

    // Finalize HTML
    content.append("</html>"); // End HTML formatting for text area

    contentArea.setText(content.toString()); // Set the formatted text

    // Add title and content to the panel
    knowledgePanel.add(title);
    knowledgePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between title and content
    knowledgePanel.add(contentArea);

    return knowledgePanel;
}

    // Action listener for sidebar buttons with animations
    private class SectionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            animateTransition(() -> cardLayout.show(mainPanel, command));  // Use animation on transition
        }
    }

    // Updated smooth transition animation
    private void animateTransition(Runnable onAnimationEnd) {
        Timer fadeOut = new Timer(10, new ActionListener() {
            float alpha = 1f;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0) {
                    ((Timer) e.getSource()).stop();
                    onAnimationEnd.run();  // Switch card when fade-out is done
                    fadeIn();
                }
                mainPanel.repaint();  // Repaint the panel to simulate opacity change
            }
        });
        fadeOut.start();
    }

    private void fadeIn() {
        Timer fadeIn = new Timer(10, new ActionListener() {
            float alpha = 0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1) {
                    ((Timer) e.getSource()).stop();
                }
                mainPanel.repaint();  // Repaint the panel to simulate opacity change
            }
        });
        fadeIn.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
