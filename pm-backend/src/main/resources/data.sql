INSERT INTO PROJECT (PROJECT_NAME)
VALUES ('Project Alpha'),
       ('Project Beta'),
       ('Project Charlie');

INSERT INTO FEATURE (FEATURE_NAME, DESCRIPTION, PROJECT_ID)
VALUES ('New search algorithm to beat Google', 'We need to aim high, and beat the best companies on the market', 1),
       ('New design on most visited pages',
        'New UI/UX for most visited pages. Need to refresh and make this pages younger', 1),
       ('Improvements to performance on server side', 'Backend improvements to speed up the response from server', 1),
       ('Advanced Data Analytics Tool',
        'Develop a comprehensive tool for data analysis to gain insights and improve decision-making', 1),
       ('Mobile Responsive Update', 'Enhance website responsiveness for a better mobile user experience', 1),
       ('Cloud Integration for Storage', 'Implement cloud storage solutions to improve data accessibility and security',
        1);

INSERT INTO TEAM (TEAM_NAME, PROJECT_ID)
VALUES ('Team Bulldogs', 1),
       ('Team Lions', 1),
       ('Team Eagles', 1);

INSERT INTO ITERATION(START_DATE, END_DATE)
VALUES ('2024-03-25T00:00:01', '2024-04-07T00:00:00'),
       ('2024-04-08T00:00:01', '2024-04-21T00:00:00'),
       ('2024-04-22T00:00:01', '2024-05-05T00:00:00'),
       ('2024-05-06T00:00:01', '2024-05-19T00:00:00'),
       ('2024-05-20T00:00:01', '2024-06-02T00:00:00');

INSERT INTO USERS (USERNAME, PASSWORD, TEAM_ID, ROLES, FIRST_NAME, LAST_NAME, PROJECT_ID, ACCOUNT_ACTIVATED)
VALUES ('admin', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 1,
        '{ADMINISTRATOR, PROJECT_SUPERVISOR, EDITING}', 'Jan',
        'Kowalski',
        1, true),
       ('user', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 1, '{EDITING}', 'Adam', 'Nowak', 1,
        true),
       ('user1', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 1, '{}', 'Krzysztof',
        'Nowak',
        1, true),
       ('user2', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 1, '{EDITING}', 'John', 'Smith', 1,
        true),
       ('user3', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 2, '{EDITING}', 'Michael',
        'Anderson',
        1, true),
       ('user4', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 2, '{EDITING}', 'Christopher',
        'Martinez', 1, true),
       ('user5', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 2, '{EDITING}', 'Sophia', 'Brown',
        1,
        true),
       ('user6', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 2, '{EDITING}', 'Jennifer',
        'Miller',
        1, true),
       ('user7', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 3, '{EDITING}', 'Benjamin', 'Hall',
        1, true),
       ('user8', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 3, '{EDITING}', 'Emma', 'Clark', 1,
        true),
       ('user9', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 3, '{EDITING}', 'Joshua', 'Walker',
        1, true),
       ('user10', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', 3, '{EDITING}', 'Jacob', 'Turner',
        1, true),
       ('user11', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', null, '{}', 'Jan', 'Kowalski',
        null, false),
       ('user12', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', null, '{}', 'Mariusz', 'Kowalczyk',
        null, false),
       ('user13', '$2a$10$AqZc8DxtqReUu9O1bZyHDeLbttCm0jIyIsbifGDGLFmqaJU6ZHc82', null, '{}', 'John', 'Johnson',
        null, false);

INSERT INTO USER_STORY (USER_STORY_NAME, DESCRIPTION, FEATURE_ID, ITERATION_IT_NUMBER, STORY_POINTS, ASSIGNED_USER_ID,
                        TEAM_ID)
VALUES ('Improved search result filtering',
        'Enhancing the filtering options for search results to provide a better user experience.', 1, 1, 1, 1, 1),
       ('Advanced search result sorting',
        'Implementing advanced sorting algorithms for search results to boost performance.', 1, 1, 2, 1, 1),
       ('User-friendly homepage redesign',
        'Redesigning the homepage with a user-centric approach to improve engagement.', 2, 1, 3, 2, 1),
       ('Profile page makeover', 'Giving the profile page a fresh new look to increase user satisfaction.', 2, 2, 5, 2,
        1),
       ('Optimized server-side caching', 'Implementing server-side caching techniques to speed up data retrieval.', 3,
        1, 8, 3, 1),
       ('Enhanced database indexing', 'Improving database indexing for faster query processing and scalability.', 3, 1,
        13, 3, 1),
       ('Streamlined registration process',
        'Simplifying the user registration process for a smoother onboarding experience.', 1, 1, 1, 4, 1),
       ('Personalized user recommendations',
        'Implementing recommendation algorithms for personalized user content suggestions.', 1, 2, 2, 4, 1),
       ('Efficient data synchronization',
        'Enhancing data synchronization processes to ensure data consistency across devices.', 2, 1, 3, 5, 2),
       ('Mobile-friendly interface', 'Adapting the interface for mobile devices to cater to a broader user base.', 2, 2,
        5, 5, 2),
       ('Improved notification system', 'Enhancing the notification system to keep users informed and engaged.', 3, 2,
        8, 6, 2),
       ('Security enhancements', 'Implementing advanced security measures to protect user data and privacy.', 3, 1, 13,
        6, 2),
       ('User feedback integration', 'Integrating a user feedback system to gather valuable insights and suggestions.',
        1, 1, 1, 7, 2),
       ('Content sharing options', 'Adding options for users to easily share content with their social networks.', 1, 1,
        2, 7, 2),
       ('Social media login', 'Allowing users to log in using their social media accounts for added convenience.', 2, 1,
        3, 8, 2),
       ('Gamification elements', 'Introducing gamification elements to increase user engagement and interaction.', 2, 1,
        5, 8, 2),
       ('Enhanced image uploading', 'Improving image uploading functionality for a smoother user experience.', 3, 2, 8,
        9, 3),
       ('Integrated user chat', 'Implementing a real-time chat feature for users to connect and communicate.', 3, 1, 13,
        9, 3),
       ('Content recommendation engine',
        'Developing a recommendation engine to suggest content based on user preferences.', 1, 2, 1, 10, 3),
       ('Accessibility improvements', 'Enhancing the platforms accessibility features to cater to all users.', 1, 2, 2,
        10, 3),
       ('Localized content support', 'Adding support for multiple languages and localized content.', 2, 1, 3, 10, 3),
       ('Interactive user tutorials', 'Creating interactive tutorials to help users make the most of the platform.', 2,
        1, 5, 11, 3),
       ('Enhanced video streaming', 'Improving video streaming quality and performance for better user experience.', 3,
        2, 8, 11, 3),
       ('Advanced content analytics', 'Implementing analytics to track user engagement and content performance.', 3, 1,
        13, 11, 3),
       ('User profile customization',
        'Allowing users to customize their profiles with personal information and themes.', 1, 1, 1, 11, 3),
       ('Enhance Data Visualization', 'Improving data representation for better analysis and understanding.', 1, 1, 1,
        1, 1),
       ('Optimize Database Queries', 'Optimization of database queries for efficiency and speed.', 3, 2, 2, 2, 1),
       ('Improve Notification System', 'Revamping the notification system for better user engagement.', 2, 3, 3, 3, 1),
       ('Refine User Authentication', 'Enhancing security and usability in the authentication process.', 4, 4, 5, 4, 1),
       ('Streamline Content Management', 'Streamlining content management for ease of use and efficiency.', 5, 1, 8, 5,
        2),
       ('Develop Mobile App', 'Creating a mobile application for better accessibility and reach.', 6, 2, 13, 6, 2),
       ('Upgrade Security Measures', 'Strengthening security to protect user data and privacy.', 1, 3, 1, 7, 2),
       ('Enhance User Interface', 'Improving the UI for a more intuitive user experience.', 2, 4, 2, 8, 2),
       ('Integrate Third-Party APIs', 'Integrating with external APIs to expand functionality.', 3, 5, 3, 9, 3),
       ('Revamp Reporting Feature', 'Overhauling the reporting feature for more insightful data.', 4, 1, 5, 10, 3),
       ('Optimize Page Load Times', 'Reducing load times for a smoother user experience.', 5, 2, 8, 11, 3),
       ('Improve Accessibility Features', 'Enhancing accessibility features for wider user inclusivity.', 6, 3, 13, 12,
        3);

-- backlog stories - team id 1
INSERT INTO USER_STORY (USER_STORY_NAME, DESCRIPTION, FEATURE_ID, STORY_POINTS, TEAM_ID)
VALUES ('Fix bugs in API', 'Do it asap', 1, 8, 1),
       ('Fix bugs in frontend', 'Do it asap', 1, 5, 1),
       ('Upgrade libraries in frontend', 'Do it asap', 1, 3, 1),
       ('Upgrade libraries in backend', 'Do it asap', 1, 8, 1),
       ('Create documentation', 'Do it asap', 1, 8, 1);

-- backlog stories - team id 2
INSERT INTO USER_STORY (USER_STORY_NAME, DESCRIPTION, FEATURE_ID, STORY_POINTS, TEAM_ID)
VALUES ('Create more bugs in API', 'Do it asap', 1, 8, 2),
       ('Create more bugs in frontend', 'Do it asap', 1, 5, 2),
       ('Delete old libraries in frontend', 'Do it asap', 1, 3, 2),
       ('Delete old libraries in backend', 'Do it asap', 1, 8, 2),
       ('Create much more documentation', 'Do it asap', 1, 8, 2),
       ('Write documentation for new workers', 'Do it asap', 1, 13, 2),
       ('Meet with customer for new details', 'Do it asap', 1, 8, 2);

-- backlog stories - team id 3
INSERT INTO USER_STORY (USER_STORY_NAME, DESCRIPTION, FEATURE_ID, STORY_POINTS, TEAM_ID)
VALUES ('Cleanup code in AP', 'Do it asap', 1, 8, 3),
       ('Cleanup code in frontend', 'Do it asap', 1, 5, 3),
       ('Create new build gradle', 'Do it asap', 1, 3, 3),
       ('Fix problems in npm', 'Do it asap', 1, 8, 3),
       ('Document everything on developer wikipedia', 'Do it asap', 1, 8, 3);

-- backlog stories - project items - without team
INSERT INTO USER_STORY (USER_STORY_NAME, DESCRIPTION, FEATURE_ID, STORY_POINTS)
VALUES ('Think how to make more money on our project', 'Do it asap', 1, 8),
       ('How to find more clients', 'Do it asap', 1, 5),
       ('How to make our program more efficient', 'Do it asap', 1, 3);


INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 1', 'Implement new feature as specified', 1),
       ('QA Testing', 'Perform quality assurance testing for Feature 1', 1),
       ('Documentation Update', 'Update documentation for Feature 1', 1);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 2', 'Implement new feature as specified', 2),
       ('QA Tests', 'Conduct quality assurance tests for Feature 2', 2),
       ('Code Review', 'Perform a code review for Feature 2', 2);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Design Improvements', 'Make design improvements as described', 3),
       ('Testing Updates', 'Update and conduct testing for Feature 3', 3),
       ('User Feedback Review', 'Review and address user feedback for Feature 3', 3);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Performance Enhancements', 'Implement performance enhancements as outlined', 4),
       ('Security Testing', 'Perform security testing for Feature 4', 4),
       ('User Documentation', 'Create user documentation for Feature 4', 4);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Optimize Server-Side', 'Optimize server-side for improved performance', 5),
       ('Load Testing', 'Conduct load testing on the updated server-side', 5),
       ('Error Handling', 'Enhance error handling for Feature 5', 5);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('User Feedback Integration', 'Integrate user feedback for Feature 6', 6),
       ('UI/UX Tweaks', 'Make UI/UX tweaks as per feedback', 6),
       ('Cross-Browser Testing', 'Conduct cross-browser testing for Feature 6', 6);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 1', 'Implement new feature as specified', 7),
       ('QA Testing', 'Perform quality assurance testing for Feature 1', 7),
       ('Documentation Update', 'Update documentation for Feature 1', 7);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 2', 'Implement new feature as specified', 8),
       ('QA Tests', 'Conduct quality assurance tests for Feature 2', 8),
       ('Code Review', 'Perform a code review for Feature 2', 8);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Design Improvements', 'Make design improvements as described', 9),
       ('Testing Updates', 'Update and conduct testing for Feature 3', 9),
       ('User Feedback Review', 'Review and address user feedback for Feature 3', 9);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Performance Enhancements', 'Implement performance enhancements as outlined', 10),
       ('Security Testing', 'Perform security testing for Feature 4', 10),
       ('User Documentation', 'Create user documentation for Feature 4', 10);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Optimize Server-Side', 'Optimize server-side for improved performance', 11),
       ('Load Testing', 'Conduct load testing on the updated server-side', 11),
       ('Error Handling', 'Enhance error handling for Feature 5', 11);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('User Feedback Integration', 'Integrate user feedback for Feature 6', 12),
       ('UI/UX Tweaks', 'Make UI/UX tweaks as per feedback', 12),
       ('Cross-Browser Testing', 'Conduct cross-browser testing for Feature 6', 12);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 1', 'Implement new feature as specified', 13),
       ('QA Testing', 'Perform quality assurance testing for Feature 1', 13),
       ('Documentation Update', 'Update documentation for Feature 1', 13);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 2', 'Implement new feature as specified', 14),
       ('QA Tests', 'Conduct quality assurance tests for Feature 2', 14),
       ('Code Review', 'Perform a code review for Feature 2', 14);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Design Improvements', 'Make design improvements as described', 15),
       ('Testing Updates', 'Update and conduct testing for Feature 3', 15),
       ('User Feedback Review', 'Review and address user feedback for Feature 3', 15);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Performance Enhancements', 'Implement performance enhancements as outlined', 16),
       ('Security Testing', 'Perform security testing for Feature 4', 16),
       ('User Documentation', 'Create user documentation for Feature 4', 16);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Optimize Server-Side', 'Optimize server-side for improved performance', 17),
       ('Load Testing', 'Conduct load testing on the updated server-side', 17),
       ('Error Handling', 'Enhance error handling for Feature 5', 17);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('User Feedback Integration', 'Integrate user feedback for Feature 6', 18),
       ('UI/UX Tweaks', 'Make UI/UX tweaks as per feedback', 18),
       ('Cross-Browser Testing', 'Conduct cross-browser testing for Feature 6', 18);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 1', 'Implement new feature as specified', 19),
       ('QA Testing', 'Perform quality assurance testing for Feature 1', 19),
       ('Documentation Update', 'Update documentation for Feature 1', 19);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Implement Feature 2', 'Implement new feature as specified', 20),
       ('QA Tests', 'Conduct quality assurance tests for Feature 2', 20),
       ('Code Review', 'Perform a code review for Feature 2', 20);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Design Improvements', 'Make design improvements as described', 21),
       ('Testing Updates', 'Update and conduct testing for Feature 3', 21),
       ('User Feedback Review', 'Review and address user feedback for Feature 3', 21);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Performance Enhancements', 'Implement performance enhancements as outlined', 22),
       ('Security Testing', 'Perform security testing for Feature 4', 22),
       ('User Documentation', 'Create user documentation for Feature 4', 22);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('Optimize Server-Side', 'Optimize server-side for improved performance', 23),
       ('Load Testing', 'Conduct load testing on the updated server-side', 23),
       ('Error Handling', 'Enhance error handling for Feature 5', 23);

INSERT INTO TASK (TASK_NAME, DESCRIPTION, USER_STORY_ID)
VALUES ('User Feedback Integration', 'Integrate user feedback for Feature 6', 24),
       ('UI/UX Tweaks', 'Make UI/UX tweaks as per feedback', 24),
       ('Cross-Browser Testing', 'Conduct cross-browser testing for Feature 6', 24);

INSERT INTO TAG (TAG_NAME)
VALUES ('Release 1.0'),
       ('Release 1.1'),
       ('Product Stabilization');

INSERT INTO USER_STORY_TAGS (TAGS_ID, USER_STORY_ID)
VALUES (1, 1),
       (3, 1),
       (2, 2),
       (1, 3),
       (1, 4),
       (3, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (3, 7),
       (1, 8),
       (1, 9),
       (1, 10);

COMMIT;