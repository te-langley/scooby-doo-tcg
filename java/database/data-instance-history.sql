BEGIN TRANSACTION;

-- Unlocks (+10)
INSERT INTO instance_history(
	instance_serial, user_id, claimed, "timestamp")
	VALUES
	('DDSMUL', 1, true, '2020-10-20 00:00:00'),
	('D58XD6', 1, true, '2020-10-20 00:00:00'),
	('EWTZA5', 1, true, '2020-10-20 00:00:00'),
	('4CEAV7', 1, true, '2020-10-20 00:00:00'),
	('TK99XE', 1, true, '2020-10-20 00:00:00'),
	('K2U2MU', 1, true, '2020-10-20 00:00:00'),
	('4SMSCD', 1, true, '2020-10-20 00:00:00'),
	('T7XGWY', 1, true, '2020-10-20 00:00:00'),
	('PAWH6M', 1, true, '2020-10-20 00:00:00'),
	('34BJDK', 1, true, '2020-10-20 00:00:00');

-- Sacrificial unlocks (+10)
INSERT INTO instance_history(
	instance_serial, user_id, claimed, "timestamp")
	VALUES
		('XZZS4F', 1, true, '2020-10-20 00:00:00'),
    	('EL7VKP', 1, true, '2020-10-20 00:00:00'),
    	('W2HB3T', 1, true, '2020-10-20 00:00:00'),
    	('FVRPSJ', 1, true, '2020-10-20 00:00:00'),
    	('RDLU86', 1, true, '2020-10-20 00:00:00'),
    	('RNUUVN', 1, true, '2020-10-20 00:00:00'),
    	('3W49L3', 1, true, '2020-10-20 00:00:00'),
    	('XA4VC8', 1, true, '2020-10-20 00:00:00'),
    	('XHSTAA', 1, true, '2020-10-20 00:00:00'),
    	('PS8TZ7', 1, true, '2020-10-20 00:00:00');

-- Releasing sacrificial claims (-10)
INSERT INTO instance_history(
	instance_serial, user_id, claimed, "timestamp")
	VALUES
		('XZZS4F', 1, false, '2020-10-20 00:01:00'),
    	('EL7VKP', 1, false, '2020-10-20 00:01:00'),
    	('W2HB3T', 1, false, '2020-10-20 00:01:00'),
    	('FVRPSJ', 1, false, '2020-10-20 00:01:00'),
    	('RDLU86', 1, false, '2020-10-20 00:01:00'),
    	('RNUUVN', 1, false, '2020-10-21 00:01:00'),
    	('3W49L3', 1, false, '2020-10-21 00:01:00'),
    	('XA4VC8', 1, false, '2020-10-21 00:01:00'),
    	('XHSTAA', 1, false, '2020-10-21 00:01:00'),
    	('PS8TZ7', 1, false, '2020-10-21 00:01:00');

-- Reclaiming a few sacrificial claims (+2)
INSERT INTO instance_history(
	instance_serial, user_id, claimed, "timestamp")
	VALUES
		('XZZS4F', 1, true, '2020-10-20 00:02:00'),
    	('RNUUVN', 1, true, '2020-10-22 00:02:00');

END TRANSACTION;

