CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    category VARCHAR(100) NOT NULL,
    question_title TEXT NOT NULL,
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255)
);
INSERT INTO question (category, question_title, option1, option2, option3)
VALUES
-- Spring Boot Questions
('Spring Boot', 'What is Spring Boot?', 'A framework', 'A programming language', 'A library'),
('Spring Boot', 'Which annotation is used to define a Spring Boot application?', '@SpringBootApplication', '@SpringApplication', '@EnableBoot'),
('Spring Boot', 'Which of the following is a feature of Spring Boot?', 'Embedded Servers', 'External configuration', 'Both'),
('Spring Boot', 'Which file is used to configure Spring Boot properties?', 'application.yml', 'application.properties', 'settings.xml'),
('Spring Boot', 'How to run a Spring Boot application?', 'Using mvn spring-boot:run', 'Using gradle bootRun', 'Both'),

-- Django Questions
('Django', 'What is Django?', 'A web framework', 'A programming language', 'A database'),
('Django', 'Which language is Django written in?', 'Python', 'Java', 'Ruby'),
('Django', 'Which command is used to start a new Django project?', 'django-admin startproject', 'django-admin init', 'django-admin new'),
('Django', 'Which file is used to configure settings in Django?', 'settings.py', 'config.py', 'app.py'),
('Django', 'Which of the following is a feature of Django?', 'ORM', 'REST Framework', 'Both');

select * from question;

select * from q;
select * from q_questions;

CREATE TABLE response (
                          id SERIAL PRIMARY KEY,
                          question_id INTEGER NOT NULL REFERENCES question(id),
                          response TEXT NOT NULL
);

INSERT INTO response (question_id, response) VALUES
                                                 (1, 'A framework'),
                                                 (1, 'A framework'),
                                                 (1, 'A programming language'),
                                                 (2, '@SpringBootApplication'),
                                                 (2, '@SpringBootApplication'),
                                                 (2, '@EnableBoot');
