--INSERT INTO users(1,'taikif', 'taikif')WHERE NOT EXISTS(SELECT * FROM users WHERE user_id = 1);
UPDATE users SET user_name = 'taikif' WHERE user_id=1;
--INSERT INTO users(user_id, user_name, user_password)VALUES(DEFAULT, 'taikif', 'taikif');
--INSERT INTO questions(question_id, domain_id, question)VALUES(DEFAULT, 1, '定量的リスク分析の最後のステップは何か？');
--INSERT INTO selections(question_id, a, b, c, d)VALUES(DEFAULT, '資産の価値を決定する', '年間発生頻度を評価する', '年間損失予測を導き出す', '費用対効果分析を実施する');
--INSERT INTO answers(question_id, answer, explanation)VALUES(DEFAULT, 'D', '定量的リスク分析の最後のステップは費用対効果分析を実施して提案された対策を実装するかどうかを組織が決定することである');
--INSERT INTO domains(question_id, domain_id, domain_name)VALUES(DEFAULT, 1,'セキュリティとリスクマネジメント');