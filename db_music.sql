/*
 Navicat Premium Data Transfer

 Source Server         : txs
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : db_music

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 29/06/2019 08:03:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_list_music
-- ----------------------------
DROP TABLE IF EXISTS `tb_list_music`;
CREATE TABLE `tb_list_music`  (
  `lid` int(11) NOT NULL DEFAULT 0,
  `mid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`lid`, `mid`) USING BTREE,
  INDEX `FK02`(`mid`) USING BTREE,
  CONSTRAINT `FK01` FOREIGN KEY (`lid`) REFERENCES `tb_musiclists` (`list_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK02` FOREIGN KEY (`mid`) REFERENCES `tb_musics` (`music_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_list_music
-- ----------------------------
INSERT INTO `tb_list_music` VALUES (1, 1);
INSERT INTO `tb_list_music` VALUES (1, 2);
INSERT INTO `tb_list_music` VALUES (2, 2);
INSERT INTO `tb_list_music` VALUES (1, 3);
INSERT INTO `tb_list_music` VALUES (2, 3);
INSERT INTO `tb_list_music` VALUES (2, 4);
INSERT INTO `tb_list_music` VALUES (4, 8);

-- ----------------------------
-- Table structure for tb_musiclists
-- ----------------------------
DROP TABLE IF EXISTS `tb_musiclists`;
CREATE TABLE `tb_musiclists`  (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `list_desc` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `list_time` char(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `list_uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`list_id`) USING BTREE,
  INDEX `FK03`(`list_uid`) USING BTREE,
  CONSTRAINT `FK03` FOREIGN KEY (`list_uid`) REFERENCES `tb_users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_musiclists
-- ----------------------------
INSERT INTO `tb_musiclists` VALUES (1, '我喜欢的', '我已经', '20180203', 1);
INSERT INTO `tb_musiclists` VALUES (2, '我不喜欢的', '我好了', '2019 02 57', 2);
INSERT INTO `tb_musiclists` VALUES (3, '我灰常喜欢的', '我死了', '2018 02 02', 1);
INSERT INTO `tb_musiclists` VALUES (4, '阿萨德', '阿萨德as', '2018 12 01', 2);

-- ----------------------------
-- Table structure for tb_musics
-- ----------------------------
DROP TABLE IF EXISTS `tb_musics`;
CREATE TABLE `tb_musics`  (
  `music_id` int(11) NOT NULL AUTO_INCREMENT,
  `music_name` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `music_art` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `music_album` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `music_path` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`music_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_musics
-- ----------------------------
INSERT INTO `tb_musics` VALUES (1, 'Just About Enough', 'Sarina Paris', 'Sarina Paris', 'mp3/1.mp3');
INSERT INTO `tb_musics` VALUES (2, '晚安', '丢火车', '晚安', 'mp3/2.mp3');
INSERT INTO `tb_musics` VALUES (3, '日文歌', 'BAAD', '未知', 'mp3/3.mp3');
INSERT INTO `tb_musics` VALUES (4, 'La La Love On My Mind', 'Ann Winsborn', 'Pink Collar Crime', 'mp3/4.mp3');
INSERT INTO `tb_musics` VALUES (5, 'Handclap', 'Begin Transmission', 'Dance with Me', 'mp3/5.mp3');
INSERT INTO `tb_musics` VALUES (6, 'Ein kleines Lied (Around The World)', 'Candee', 'Hier kommt Candee!', 'mp3/6.mp3');
INSERT INTO `tb_musics` VALUES (7, 'Walking In the Sun (Defrix Remix)', 'Defrix', '最新热歌慢摇3', 'mp3/7.mp3');
INSERT INTO `tb_musics` VALUES (8, '走马（Cover：陈粒）', '摩登兄弟', '摩登兄弟', 'mp3/8.mp3');
INSERT INTO `tb_musics` VALUES (9, '起风了（Cover 高橋優）', '买辣椒也用券', '起风了', 'mp3/9.mp3');

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_pwd` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_nick` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_sex` char(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_pic` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_desc` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES (1, 'asdasdasd', '12345678', 'txs', '?', 'photos/1547648488211.png', '				wofafasa d	');
INSERT INTO `tb_users` VALUES (2, 'qweqweqwe', '456789123', 'txs22', 'M', 'photos/1547798785613.', 'asdasdasdasd');
INSERT INTO `tb_users` VALUES (3, 'qweqweqwe23', '789456123', 'txs22333', '?', 'photos/1547649426204.png', '				wofafasa dwwwasdasd	');
INSERT INTO `tb_users` VALUES (4, 'dasdasd', '123456789', 'niansdia', '?', 'photos/1547687396047.png', '				ashdad	');
INSERT INTO `tb_users` VALUES (5, 'zhangsansan', '123456789', '???', '?', 'photos/1547692060067.png', '				???????	');
INSERT INTO `tb_users` VALUES (6, 'zhangsansan', '123456789', '???', '?', 'photos/1547692081234.png', '				???????	');
INSERT INTO `tb_users` VALUES (7, 'qqweqwe', '789456123', 'awii', 'M', 'photos/1547709922435.png', 'asdasd');
INSERT INTO `tb_users` VALUES (8, 'a', '123', 'asd', 'M', 'photos/1547726237735.png', 'wadasd ');
INSERT INTO `tb_users` VALUES (9, 'aqweqwe', '123456789', 'qweqwe', 'M', 'photos/1547726351649.png', 'wadasd qwe');
INSERT INTO `tb_users` VALUES (10, 'aqweqwe', '789456123', 'qweqwe', 'F', 'photos/1547726411477.png', 'wadasd qweqwe');
INSERT INTO `tb_users` VALUES (11, 'aqweqwe', '789456123', 'qweqwe', 'F', 'photos/1547726716504.png', 'wadasd qweqwe');
INSERT INTO `tb_users` VALUES (12, 'tasd', '123456789', 'mylove', 'M', 'photos/1547748812515.png', 'asdasd');
INSERT INTO `tb_users` VALUES (13, '123123', '123123', '123', 'M', 'photos/1547907410919.png', '123');
INSERT INTO `tb_users` VALUES (14, 'sdfsd', 'sdf', 'sdfsd', 'M', 'photos/1549598920264.', '');
INSERT INTO `tb_users` VALUES (15, 'stsdfsf', 'gfgfdgf', 'hgchg', 'M', 'photos/1549599447010.', '');
INSERT INTO `tb_users` VALUES (16, 'rtdtrdtr', 'rdtrdtr', 'trdtrdt', 'M', 'photos/1549599603163.', '');

SET FOREIGN_KEY_CHECKS = 1;
