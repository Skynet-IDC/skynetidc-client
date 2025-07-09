
-- Thêm cột app_id nếu chưa có
ALTER TABLE gb_package ADD COLUMN IF NOT EXISTS app_id INT;

-- Thêm hoặc cập nhật dữ liệu theo id
INSERT INTO gb_package (
  id, name, description, duration, price, original_price, discount_percent,
  is_hot, is_active, ios_product_id, android_product_id, position, app_id
) VALUES
(1, '1 tháng', 'Gói 1 tháng', 30, 99000, 99000, NULL, NULL, 0, 'com.gobiz.app1.premium99', 'gobiz_1thang', 1, 1),
(2, 'Premium 3 tháng', 'Gói 3 tháng', 90, 490000, NULL, NULL, 1, 1, 'com.gobiz.app1.3month', 'gobiz_3months', 2, 1),
(3, 'Premium 1 năm', 'Gói 1 năm', 365, 990000, 1240000, 20, 1, 1, 'com.gobiz.app1.1year', 'gobiz_1year', 4, 1),
(4, 'Premium 6 tháng', 'Gói 6 tháng', 180, 690000, 780000, 15, 1, 1, 'com.gobiz.app1.6month', 'gobiz_6months', 3, 1),
(5, 'Pro gia sư', 'Gói Pro Gia Sư', 365, 5500000, 7860000, 30, 1, 1, 'com.gobiz.app1.coach', 'gobiz_coaching', 5, 1),
(6, '1 tháng', 'Gói 1 tháng', 30, 99000, 99000, NULL, NULL, 0, 'com.mepro1.app1.premium99', 'mepro_1thang', 1, 2),
(7, 'Premium 3 tháng', 'Gói 3 tháng', 90, 490000, NULL, NULL, 1, 1, 'com.mepro1.app1.3month', 'mepro_3months', 2, 2),
(8, 'Premium 1 năm', 'Gói 1 năm', 365, 990000, 1240000, 20, 1, 1, 'com.mepro1.app1.1year', 'mepro_1year', 4, 2),
(9, 'Premium 6 tháng', 'Gói 6 tháng', 180, 690000, 780000, 15, 1, 1, 'com.mepro1.app1.6month', 'mepro_6months', 3, 2),
(10, 'Pro gia sư', 'Gói Pro Gia Sư', 365, 5500000, 7860000, 30, 1, 1, 'com.mepro1.app1.coach', 'mepro_coaching', 5, 2)
ON DUPLICATE KEY UPDATE
  name = VALUES(name),
  description = VALUES(description),
  duration = VALUES(duration),
  price = VALUES(price),
  original_price = VALUES(original_price),
  discount_percent = VALUES(discount_percent),
  is_hot = VALUES(is_hot),
  is_active = VALUES(is_active),
  ios_product_id = VALUES(ios_product_id),
  android_product_id = VALUES(android_product_id),
  position = VALUES(position),
  app_id = VALUES(app_id);
