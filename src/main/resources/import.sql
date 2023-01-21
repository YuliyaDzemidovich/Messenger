-- create two users - John and Alice
INSERT INTO user(email, first_name, last_name, is_blocked, login, password) VALUES ('email@example.com', 'john', 'doe', false, 'johnD', '{bcrypt}$2a$10$OVAMRCk4OtUaViiKqTLizePy.ycFrEfqKITxVC7ejlNJ1mU.3Zf0i');
INSERT INTO user(email, first_name, last_name, is_blocked, login, password) VALUES ('email2@example.com', 'alice', 'wales', false, 'aliceW', '{bcrypt}$2a$10$4SN5d7XxhR9f1ItxPvvRQONEnYKqwcHZEMZOU3si8y0Eiu4/j0GWq');

-- create chat between John and Alice
INSERT INTO chat(creator_id, name) VALUES ('1', 'John&Alice chat');
INSERT INTO users_chats(chat_id, user_id) VALUES ('1', '1'), ('1', '2');