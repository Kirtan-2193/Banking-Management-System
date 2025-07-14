--
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.permission (permission_id, permission_name, status) VALUES ('9f079d2e-5d83-4039-9246-b13de9986f99', 'VIEW_ROLE', 'ACTIVE');


--
-- Data for Name: role_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role_permission (role_permission_id, role_id, permission_id, status) VALUES ('28b7585c-fdea-4132-988c-59eb13f837d5', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '9f079d2e-5d83-4039-9246-b13de9986f99', 'ACTIVE'); -- USER_REGISTER (Admin)


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('18b7b37d-75c4-40e6-b98d-dedd5d5418c2', 'kim44@gmail.com', 'Kirtan', 'MALE', 'Bhavsar', '$2a$12$7lFM7XmSnpebpWrb/Hdw/OZqa.eDNKQ/n/ETUSFmfucwltopst/GW', '8956895674');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number) VALUES ('a54a4399-b315-4b80-9560-2b5c63ffbcaf', 'dp42@gmail.com', 'diptesh', 'MALE', 'patel', '$2a$12$AzT7LXDx1OV/Wso3Mq5okOUr2uWDUN0lWc3gWNS0hRyGVbBvlhbpC', '7777799999');


--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.accounts(account_id, account_balance, account_branch, account_number, account_type, account_status, user_id) VALUES ('4cc8eb76-14ed-43ed-825b-1b8d91aa4114', 4386943, 'AXIS-GOTA', 880976986130, 'Saving', 'ACTIVE', '18b7b37d-75c4-40e6-b98d-dedd5d5418c2');