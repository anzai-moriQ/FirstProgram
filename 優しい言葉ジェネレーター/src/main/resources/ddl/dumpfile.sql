--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.16
-- Dumped by pg_dump version 9.6.16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: games; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public.games (
    code integer NOT NULL,
    grade integer,
    name text,
    caption text
);


ALTER TABLE public.games OWNER TO student;

--
-- Name: saying; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public.saying (
    code integer NOT NULL,
    grade text,
    word text
);


ALTER TABLE public.saying OWNER TO student;

--
-- Name: saying_code_seq; Type: SEQUENCE; Schema: public; Owner: student
--

CREATE SEQUENCE public.saying_code_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.saying_code_seq OWNER TO student;

--
-- Name: saying_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: student
--

ALTER SEQUENCE public.saying_code_seq OWNED BY public.saying.code;


--
-- Name: users; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public.users (
    code integer NOT NULL,
    name text,
    password text
);


ALTER TABLE public.users OWNER TO student;

--
-- Name: users_code_seq; Type: SEQUENCE; Schema: public; Owner: student
--

CREATE SEQUENCE public.users_code_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_code_seq OWNER TO student;

--
-- Name: users_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: student
--

ALTER SEQUENCE public.users_code_seq OWNED BY public.users.code;


--
-- Name: words; Type: TABLE; Schema: public; Owner: student
--

CREATE TABLE public.words (
    code integer NOT NULL,
    stress integer,
    word text
);


ALTER TABLE public.words OWNER TO student;

--
-- Name: words_code_seq; Type: SEQUENCE; Schema: public; Owner: student
--

CREATE SEQUENCE public.words_code_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.words_code_seq OWNER TO student;

--
-- Name: words_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: student
--

ALTER SEQUENCE public.words_code_seq OWNED BY public.words.code;


--
-- Name: saying code; Type: DEFAULT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.saying ALTER COLUMN code SET DEFAULT nextval('public.saying_code_seq'::regclass);


--
-- Name: users code; Type: DEFAULT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.users ALTER COLUMN code SET DEFAULT nextval('public.users_code_seq'::regclass);


--
-- Name: words code; Type: DEFAULT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.words ALTER COLUMN code SET DEFAULT nextval('public.words_code_seq'::regclass);


--
-- Data for Name: games; Type: TABLE DATA; Schema: public; Owner: student
--

COPY public.games (code, grade, name, caption) FROM stdin;
2	10	スプラトゥーン2	2017年7月発売。NintendoSwitchの中でも大ヒット作としてあげられることの多いTPSシューティングゲーム
3	10	FINAL FANTASY Record Keeper	2014年5月サービス開始。ファイナルファンタジーシリーズの外伝。基本プレイ無料のスマホアプリ
4	30	Battlefield 1	2016年10月発売。最大64人で遊べるお祭り系FPS。同じシリーズのbf5よりもとっつきやすい
5	30	SEKIRO	2019年3月発売。面白いがクリアまで何回も挫折する「死にゲー」と呼ばれるタイプのゲーム。比較的精神が穏やかに時にやるのがおすすめ
6	30	DEATH STRANDING	2019年11月発売。別名「UberEATs」。メタルギアシリーズの小島秀夫が作った完全新作ゲーム
8	50	Apex Legends	2019年2月サービス開始。基本プレイ無料のバトルロイヤルゲーム。バグの少なさや建築等の特殊技術がいらないため気軽に始められる
9	50	モンスターストライク	2013年10月サービス開始。長期に渡って人気を誇るソーシャルゲーム。操作が簡単。
10	70	BIOHAZARD5	2009年発売。PS4やNintendoSwitchでもできるホラー系アクションゲーム。ゾンビ系のモンスターを手当たり次第に倒せるためストレス発散にもなる
11	70	Grand Theft Auto V	2013年10月発売。ビデオゲーム史上最も売れたといわれるゲーム。オープンワールド内で自由に動き回れるため様々な遊び方ができることで有名。一応R18指定なので注意
12	70	Dead by Daylight	2013年10月サービス開始。長期に渡って人気を誇るソーシャルゲーム。操作が簡単。
13	100	ドラゴンクエスト XI	2017年7月発売。正規ナンバリングでは初のPS4で発売された王道RPG。過去作をやっていなくても十分楽しめる
1	10	グランブルーファンタジー	2014年サービス開始。スマホ系王道RPG。ゆったりとこつこつ遊ぶならおすすめ
14	100	SIREN:NT	2008年7月発売。CMが怖すぎるため放送禁止になったという過去を持つPS3用ゲーム。「SIREN」シリーズの中では外伝的な存在とされているが大きな虫やゾンビっぽい敵をいっぱい倒せるためストレス発散にぴったりのゲーム
15	100	BIOHAZARD 7 resident evil	2017年1月発売。アクションゲームからの脱却を目指したバイオハザードの最新タイトル。通常版とグロテスク版があり、後者は過去のバイオハザードを感じさせないほどの強烈さを持つ。ただちゃんとバイオハザード感もあるのでおすすめ。
7	50	モンスターハンターワールドアイスボーン	2019年9月。「モンスターハンターワールド」に大規模DLコンテンツを搭載した大人気アクションゲーム
\.


--
-- Data for Name: saying; Type: TABLE DATA; Schema: public; Owner: student
--

COPY public.saying (code, grade, word) FROM stdin;
1	N	ああ言えばこう言う
2	N	閑古鳥が鳴く
3	N	触らぬ神に祟りなし
4	N	徒手空拳
5	N	笛吹けども踊らず
6	N	焼石に水
7	N	物見遊山
8	N	月に叢雲花に風
9	N	朝令暮改
10	N	暖簾に腕押し
11	R	水を得た魚
12	R	不倶戴天
13	R	酔生夢死
14	R	濡れ手で粟
15	R	風雲に乗じる
16	R	生生流転
17	R	西から日が出る
18	SR	桃源郷
20	SR	物は考えよう
21	SR	損せぬ人に儲けなし
22	SR	門前雀羅
23	SR	色即是空
24	UR	天地開闢
\.


--
-- Name: saying_code_seq; Type: SEQUENCE SET; Schema: public; Owner: student
--

SELECT pg_catalog.setval('public.saying_code_seq', 1, false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: student
--

COPY public.users (code, name, password) FROM stdin;
1	teramoto	anzai
2	teramoto	anzai
3	teramoto	anzai
4	teramoto	teratera
5	teramoto	13
6	渋谷	ikebukuro
7	犬	wanwan
8	代々木	kouen
9	原宿	neo
10	上野	panda
11	水道橋	kyojinn
12	エルダー	skyrim
13	フォールアウト	ayomic
14	FPS	cod
15	武蔵	kosugi
16	中野	sakaue
17	ゴールデン街	shinjuku
18	スカイツリー	kinnsityou
19	溝ノ口	nocty
20	2020	tokyo
21	NPO	houjin
22	ザナルカンド	FF
23	アレフガルド	DQ
24	10万円	hosi
25	大宰府	tennmannguu
26	A	aaa
27	zai	anzai
28	bio	haza
29	tea	tea
30	bb	bb
31	usa	usa
32	fortune	for
34	panda	siro
35	m	mm
36	pp	p
33	fort	nnnnnnnn
37	popo	ooo
38	mac	dona
39	ww	ee
40	ruby	java
41	04	saza
42	pass	passcode
43	こんにちは	hello
44	いつ	which
\.


--
-- Name: users_code_seq; Type: SEQUENCE SET; Schema: public; Owner: student
--

SELECT pg_catalog.setval('public.users_code_seq', 44, true);


--
-- Data for Name: words; Type: TABLE DATA; Schema: public; Owner: student
--

COPY public.words (code, stress, word) FROM stdin;
1	60	いつかこの日さえも楽しく思い出すことがあるだろう
2	90	心配事の98％は、取り越し苦労だ。
3	80	自分を信じてください。あなたは自分が考えるより、遥かに多くのことを知っているのです。
4	50	自分の居場所なんて自分で決めればいいんだよ。
5	70	大丈夫、心配するな。何とかなる
6	90	人間は、大体何にでも耐えられる。
7	50	ひとつのドアが閉まっている時、もっとたくさんのドアが開いているんだよ
8	80	元気を出しなさい。今日の失敗ではなく、明日訪れるかもしれない成功について考えるのです。
9	40	起こったことをあるがままに受け入れよ。それが不幸な結果を克服する第一歩である。
10	50	ぐちをこぼしたっていいがな　弱音を吐いたっていいがな　人間だもの　たまには涙をみせたっていいがな　生きているんだもの
11	30	お前の道を進め、人には勝手なことを言わせておけ。
12	60	今あるものを一生懸命やれば次につながっていく
13	10	人の個性に良い悪いはない
14	20	続けることは難しいが続けたことだけが自信になる。
15	100	山は西からも東からでも登れる。自分が方向を変えれば新しい道はいくらでも開ける
16	150	例えその恐怖が合理的であっても挑戦に値することであればその恐れをやり過ごして前に進むべきだ
17	200	あなたは苦しんだ分だけ愛の深い人に育っているのです
18	10	自分の人生は自分が主役
19	20	どう思われるかより、どうありたいかが大事
20	30	これは負けじゃなくて、勝ちの途中なんだ
21	40	どうせ失敗をするなら、自分が選んだ人生で失敗しよう！
22	70	人生に失敗がないと人生を失敗する
23	100	準備をしておこう。チャンスはいつか訪れる
24	150	努力は「天命」さえも変える
25	200	大事なのは自分がもうダメかもって思ったそこからがスタート。そこからどれだけ頑張るかで自分の限界が決まる。
27	50	大変だね。いつもお疲れ様。
28	30	諦めないで何事も。無理しないで何もかも
29	50	必死にやった結果の失敗は後悔しなくていい
26	60	ギリギリの状態に何度も追い込まれた人でないと、直感力は働かない
\.


--
-- Name: words_code_seq; Type: SEQUENCE SET; Schema: public; Owner: student
--

SELECT pg_catalog.setval('public.words_code_seq', 29, true);


--
-- Name: games games_pkey; Type: CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.games
    ADD CONSTRAINT games_pkey PRIMARY KEY (code);


--
-- Name: saying saying_pkey; Type: CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.saying
    ADD CONSTRAINT saying_pkey PRIMARY KEY (code);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (code);


--
-- Name: words words_pkey; Type: CONSTRAINT; Schema: public; Owner: student
--

ALTER TABLE ONLY public.words
    ADD CONSTRAINT words_pkey PRIMARY KEY (code);


--
-- PostgreSQL database dump complete
--

