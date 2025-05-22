module.exports = {
  SUCCESS: 0,
  COMMON_FAIL: 1,

  /** ACCOUNT */
  ACCOUNT_EXIST: 2, // Tài khoản đã tồn tại
  OTP_INVALID: 3, // Mã xác thực không hợp lệ
  OTP_LIMIT_REACHING: 4, // Vượt quá số lần lấy mã xác thực
  ACCOUNT_NOT_EXISTS: 5, // Số điện thoại chưa đăng ký tài khoản

  /** LICENSE */
  ACTIVE_CODE_NOT_EXIST: 6, // Mã kích hoạt không tồn tại
  ACTIVE_CODE_ALREADY_USED: 7 // Mã kích hoạt đã được sử dụng
};
