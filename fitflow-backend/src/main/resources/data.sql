--Trainers
INSERT INTO Trainer (id, first_name, last_name, email)
VALUES (10000, 'John', 'Doe', 'johndoe@example.com');
INSERT INTO Trainer (id, first_name, last_name, email)
VALUES (20000, 'Jane', 'Smith', 'janesmith@example.com');
INSERT INTO Trainer (id, first_name, email)
VALUES (30000, 'Alex', 'alex@example.com');
INSERT INTO Trainer (id, first_name, last_name)
VALUES (40000, 'Michael', 'Johnson');
INSERT INTO Trainer (id, first_name, last_name, email)
VALUES (50000, 'Sarah', 'Wilson', 'sarahwilson@example.com');

--Trainees
INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (10000, 'Peter', 'Parker', 'peterparker@example.com',100,180,false);
INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (20000, 'Mary', 'Watson', 'marywatson@example.com',70,150,false);
INSERT INTO Trainee (id, first_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (30000, 'Tony', 'tony@example.com',60,110,false);
INSERT INTO Trainee (id, first_name, last_name,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (40000, 'Bruce', 'Wayne',50,50,false);
INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (50000, 'Diana', 'Prince', 'dianaprince@example.com',50,100,false);
INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (1100000, 'Peter', 'Parker', 'peterparker@example.com',100000,180,false);

INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (2110000, 'Mary', 'Watson', 'marywatson@example.com',70000,150,false);

INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (3110000, 'Tony', 'Stark', 'tonystark@example.com',60000,110,false);

INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (4110000, 'Bruce', 'Wayne', 'brucewayne@example.com',50000,50,false);

INSERT INTO Trainee (id, first_name, last_name, email,weight_in_grams,height_in_centimeters,is_deleted)
VALUES (5110000, 'Diana', 'Prince', 'dianaprince@example.com',50000,100,false);

--Mentorships
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (5110000, '2023-08-01', '2023-12-31', 2000.00, 5110000, 10000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (4110000, '2023-08-01', '2023-12-31', 2000.00, 4110000, 10000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (3110000, '2023-08-01', '2023-12-31', 2000.00, 3110000, 10000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (2110000, '2023-08-01', '2023-12-31', 2000.00, 2110000, 10000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (1100000, '2023-08-01', '2023-12-31', 2000.00, 1100000, 10000);

INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (10000, '2023-08-01', '2023-12-31', 2000.00, 10000, 10000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (20000, '2023-07-01', '2023-11-30', 2500.00, 20000, 20000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (30000, '2023-09-01', '2024-01-31', 3000.00, 30000, 30000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (40000, '2023-07-15', '2024-01-14', 1500.00, 40000, 40000);
INSERT INTO Mentorship (id, start_date, end_date, price, trainee_id, trainer_id)
VALUES (50000, '2023-08-01', '2024-01-31', 3500.00, 50000, 50000);

--Exercises
INSERT INTO Exercise (id, name, tips)
VALUES (10000, 'Push ups', 'Keep your back straight');
INSERT INTO Exercise (id, name, tips)
VALUES (20000, 'Squats', 'Keep your back straight');
INSERT INTO Exercise (id, name, tips)
VALUES (30000, 'Pull ups', 'Keep your back straight');
INSERT INTO Exercise (id, name, tips)
VALUES (40000, 'Sit ups', 'Keep your back straight');

--Body parts
INSERT INTO Body_Part (id, name)
VALUES (10000, 'Chest');
INSERT INTO Body_Part (id, name)
VALUES (20000, 'Right Arm');
INSERT INTO Body_Part (id, name)
VALUES (30000, 'Left Arm');
INSERT INTO Body_Part (id, name)
VALUES (40000, 'Right Thigh');
INSERT INTO Body_Part (id, name)
VALUES (50000, 'Left Thigh');
INSERT INTO Body_Part (id, name)
VALUES (60000, 'Right Calf');
INSERT INTO Body_Part (id, name)
VALUES (70000, 'Left Calf');
INSERT INTO Body_Part (id, name)
VALUES (80000, 'Waist');
INSERT INTO Body_Part (id, name)
VALUES (90000, 'Shoulders');

--Reports

INSERT INTO Report (id, date, description, trainee_id, text)
VALUES (10000, '2023-08-01', 'I did 10 push ups', 10000, 'This week was productive, and the trainee showed a lot of progress in their fitness regimen.');

INSERT INTO Report (id, date, description, trainee_id, text)
VALUES (20000, '2023-08-02', 'I did 10 push ups', 10000, 'The trainee showed consistent performance with their exercises.');

INSERT INTO Report (id, date, description, trainee_id, text)
VALUES (30000, '2023-08-03', 'I did 10 push ups', 10000, 'Despite a slight dip in performance on day 3, the trainee maintained a positive attitude.');

INSERT INTO Report (id, date, description, trainee_id, text)
VALUES (40000, '2023-08-04', 'I did 10 push ups', 10000, 'On the last day of the week, the trainee excelled and set a new personal record.');


--Training Plans
INSERT INTO Training_Plan (id, name, description, start_date, end_date, trainee_id)
VALUES (10000, 'Plan 1', 'This is plan 1', '2023-08-01', '2023-12-31', 10000);

INSERT INTO Training_Plan (id, name, description, start_date, end_date, trainee_id)
VALUES (20000, 'Plan 2', 'This is plan 2', '2023-08-01', '2023-12-31', 10000);

INSERT INTO Training_Plan (id, name, description, start_date, end_date, trainee_id)
VALUES (30000, 'Plan 3', 'This is plan 3', '2023-08-01', '2023-12-31', 10000);


--Training Unit
INSERT INTO Training_Unit (id, name, tips, training_plan_id)
VALUES (10000, 'Unit 1', 'This is unit 1', 10000);
INSERT INTO Training_Unit (id, name, tips, training_plan_id)
VALUES (20000, 'Unit 2', 'This is unit 2', 10000);
INSERT INTO Training_Unit (id, name, tips, training_plan_id)
VALUES (30000, 'Unit 3', 'This is unit 3', 10000);


--Exercise Training Unit
INSERT INTO Exercise_Training_Unit (id, number_of_repetitions, number_of_sets, exercise_id, training_unit_id)
VALUES (10000, 10, 3, 10000, 10000);
INSERT INTO Exercise_Training_Unit (id, number_of_repetitions, number_of_sets, exercise_id, training_unit_id)
VALUES (20000, 10, 3, 20000, 10000);
INSERT INTO Exercise_Training_Unit (id, number_of_repetitions, number_of_sets, exercise_id, training_unit_id)
VALUES (30000, 10, 3, 30000, 10000);
INSERT INTO Exercise_Training_Unit (id, number_of_repetitions, number_of_sets, exercise_id, training_unit_id)
VALUES (40000, 10, 3, 40000, 10000);

--Reports
--Reports
INSERT INTO Report (id, date, description, trainee_id)
VALUES (1, '2023-07-05', 'I did 20 push ups today.', 10000);
INSERT INTO Report (id, date, description, trainee_id)
VALUES (2, '2023-07-06', 'I ran 5 miles today.', 20000);
INSERT INTO Report (id, date, description, trainee_id)
VALUES (3, '2023-07-07', 'I did 30 minutes of yoga today.', 30000);
INSERT INTO Report (id, date, description, trainee_id)
VALUES (4, '2023-07-08', 'I did 15 pull ups today.', 40000);
INSERT INTO Report (id, date, description, trainee_id)
VALUES (5, '2023-07-09', 'I did 10 squats today.', 50000);

--Muscle groups

INSERT INTO Muscle_Group (id, name)
VALUES (1000, 'Chest');
INSERT INTO Muscle_Group (id, name)
VALUES (1001, 'Biceps');
INSERT INTO Muscle_Group (id, name)
VALUES (1002, 'Triceps');
INSERT INTO Muscle_Group (id, name)
VALUES (1003, 'Back');
INSERT INTO Muscle_Group (id, name)
VALUES (1004, 'Legs');
INSERT INTO Muscle_Group (id, name)
VALUES (1005, 'Shoulders');
INSERT INTO Muscle_Group (id, name)
VALUES (1006, 'Abs');
INSERT INTO Muscle_Group (id, name)
VALUES (1007, 'Glutes');
INSERT INTO Muscle_Group (id, name)
VALUES (1008, 'Forearms');
INSERT INTO Muscle_Group (id, name)
VALUES (1009, 'Quads');
INSERT INTO Muscle_Group (id, name)
VALUES (1010, 'Hamstrings');
INSERT INTO Muscle_Group (id, name)
VALUES (1011, 'Calves');
INSERT INTO Muscle_Group (id, name)
VALUES (1012, 'Lats');
INSERT INTO Muscle_Group (id, name)
VALUES (1013, 'Traps');

--EXERCISE_MUSCLE_GROUPS
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (10000, 1000);
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (10000, 1002);
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (10000, 1005);
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (20000, 1004);
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (20000, 1007);
INSERT INTO EXERCISE_MUSCLE_GROUPS (EXERCISES_ID, MUSCLE_GROUPS_ID)
VALUES (20000, 1009);

