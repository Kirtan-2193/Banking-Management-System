--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (role_id, role_name, status) VALUES ('hg6597d6-e225-4b77-ba7a-756bd88f26cfx', 'Admin', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('78jk1299-dab3-4a27-80b1-4cd991a2klo2', 'Manager', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('12lk4587-abc4-4d19-91c3-5bc231x2opq3', 'Teller', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('34nm6790-bcd5-4e31-92d4-6ef452y3rst4', 'Customer', 'ACTIVE');
INSERT INTO public.role (role_id, role_name, status) VALUES ('23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'Loan Officer', 'ACTIVE');



--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('18b7b37d-75c4-40e6-b98d-dedd5d5418c2', 'kimybh44@gmail.com', 'Kirtan', 'Male', 'Bhavsar', '$2a$12$7lFM7XmSnpebpWrb/Hdw/OZqa.eDNKQ/n/ETUSFmfucwltopst/GW', '8956895674', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('9b47fa68-3a3e-4f40-9df8-90f2e4a43b9a', 'gajjarharsh1810@gmail.com', 'Hitarth', 'Male', 'Gajjer', '$2a$12$meH/SK0PAiQNEzxhJIvh7e/yaXSR0NRzHVaCirjdoa/i07jRSHKiG', '7895648547', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('2c0fbc11-47cd-4c47-a8e6-1b7c8c4e31b7', 'priyanshsathvara27@gmail.com', 'Priyansh', 'Male', 'Sathvara', '$2a$12$42bSF5w2hqInXkTK3Tspl.SYVBzmRJNZkAcOoI3O0PmXwC.KqwCh6', '8956234582', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('5d2397f0-34b1-43ea-9c62-1c9d9f01f647', 'poojaprajapati082005@gmail.com', 'Pooja', 'Female', 'Prajapati', '$2a$12$MITeEdfKI994iSs2fhZHfODi.J.68jq9wwt.ezHyBHzk5.V.kfc3i', '7586944361', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('7a15b8c6-46b5-4a84-b09c-65d16a0836f5', 'jainmahi1848@gmail.com', 'Mahima', 'Female', 'Jain', '$2a$12$iULCxivCWpuDHSEvh18PPeW0ckVfScqrgMNF0LdrWZnfS6P4yZet6', '9476851973', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('0e2d3c98-50c9-4e1a-b8fc-16ad726bc193', 'hetpatel12@gmail.com', 'Het', 'Male', 'Patel', '$2a$12$17tW7A8TNS4x65E8ne8EKu04xBwIEDfsDVdWDVpk3pmD4hv4K/kN.', '9486751634', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('4cf64db1-82e9-498b-8ec1-3c5179c73119', 'yashdarji27@gmail.com', 'Yash', 'Male', 'Darji', '$2a$12$WmXdz0x3IXQN13pYyJfvsueBTWM8Jc0VclPRRhn15dI/3tQyVDFP6', '7695840934', 'ACTIVE');
INSERT INTO public.users(user_id, email, first_name, gender, last_name, password, phone_number, status) VALUES ('b89f93b2-3946-4563-bd21-15cc3e841bf3', 'preetpatel47@gmail.com', 'Preet', 'Male', 'Patel', '$2a$12$YiNKCSUU4KfJD5hbreXoJOC0xqeOPfVG8GzTyeC/IMEMi1NJhEuPO', '9073824063', 'ACTIVE');



--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('8ed7441f-ab08-4974-a1e2-1c5a63ce857f', 'ACTIVE', 'hg6597d6-e225-4b77-ba7a-756bd88f26cfx', '18b7b37d-75c4-40e6-b98d-dedd5d5418c2'); --kirtan-A
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('f0c5d6a2-83eb-465f-950f-1c0aa5e86b1d', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '9b47fa68-3a3e-4f40-9df8-90f2e4a43b9a'); --hitarth-C
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('6a73f1a7-568f-4c71-bc48-f9308d17d3e0', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '2c0fbc11-47cd-4c47-a8e6-1b7c8c4e31b7'); --priyansh-C
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('c2138e65-940d-4d14-91a0-83d632ed9bb1', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '5d2397f0-34b1-43ea-9c62-1c9d9f01f647'); --pooja-C
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('1e4a9f5c-0d4c-4c53-a925-b4a7c5e19c43', 'ACTIVE', '34nm6790-bcd5-4e31-92d4-6ef452y3rst4', '7a15b8c6-46b5-4a84-b09c-65d16a0836f5'); --mahima-C
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('e31cde77-d6cc-44a1-95d5-502d58d1e6b0', 'ACTIVE', '12lk4587-abc4-4d19-91c3-5bc231x2opq3', '0e2d3c98-50c9-4e1a-b8fc-16ad726bc193'); --het-T
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('84bfa8b9-8c04-47b5-9c94-fb673d142d2a', 'ACTIVE', '78jk1299-dab3-4a27-80b1-4cd991a2klo2', '4cf64db1-82e9-498b-8ec1-3c5179c73119'); --yash-M
INSERT INTO public.user_roles(user_role_id, status, role_id, user_id) VALUES ('36f9a5f3-ef9e-44da-8ec3-d4cf8a1472b2', 'ACTIVE', '23qr3456-def7-4g53-94f6-8ij894a5xyz6', 'b89f93b2-3946-4563-bd21-15cc3e841bf3'); --preet-L


--
-- Data for Name: Account; Type: TABLE DATA; Schema: public; Owner: postgres
--
INSERT INTO public.accounts(account_id, account_branch, account_number, account_type, account_status, user_id, account_balance, interest_rate, transaction_pin account_creation_date, next_interest_date) VALUES ('52fa2ddc-17f7-48b9-9cb1-090061db1dc6', 'AXIS-THALTEJ', 877834838966, 'Saving', 'ACTIVE', '2c0fbc11-47cd-4c47-a8e6-1b7c8c4e31b7', 812000, 5, '$2a$12$xdMHHLu67xOSKADRc1gNEOCYPE090wBn4EUzlwqbOcXs6O2ILgH4m', '2025-09-09', '2025-10-09');
INSERT INTO public.accounts(account_id, account_branch, account_number, account_type, account_status, user_id, account_balance, interest_rate, transaction_pin account_creation_date, next_interest_date) VALUES ('9447470f-da17-4586-a298-825bc6e14e46', 'SBI-VADAJ', 817243541567, 'Saving', 'ACTIVE', '9b47fa68-3a3e-4f40-9df8-90f2e4a43b9a', 375000, 5, '$2a$12$W/b6LV1reTIqcX44CQFSpek11aowU96k0/gxmY0IG.QlGvdBsdAL2', '2025-09-08', '2025-10-08');
INSERT INTO public.accounts(account_id, account_branch, account_number, account_type, account_status, user_id, account_balance, interest_rate, transaction_pin account_creation_date, next_interest_date) VALUES ('c3aee16b-a7d3-4522-900b-bf1ce280d383', 'HDFC-GOTA', 861113385396, 'Saving', 'ACTIVE', '7a15b8c6-46b5-4a84-b09c-65d16a0836f5', 445000, 4.5, '$2a$12$9f8GP6qhvK8yfRfEdVeXauXAdS.E88YYo66eCh75/vafCoH/ELMFm', '2025-09-09', '2025-10-09');
