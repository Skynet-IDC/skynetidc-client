const questionRepository = require('../repositories/QuestionRepository');

module.exports = {
    getMissionBySkill: async function (skill) {
        return [
            {
                name: 'Viết Email',
                description: 'Viết Email gửi đến cửa hàng/nhân viên bán hàng.'
            },
            {
                name: 'Nội Dung Sản Phẩm',
                description: 'Nêu rõ sản phẩm bị lỗi'
            },
            {
                name: 'Trình bày',
                description: 'Trình bày vấn đề gặp phải'
            },
            {
                name: 'Yêu Cầu Hỗ Trợ',
                description: 'Yêu cầu hỗ trợ kiểm tra/sửa chữa/giải quyết'
            },
            {
                name: 'Kết thúc email',
                description: 'Kết thúc email bằng lời cảm ơn'
            }
        ];
    },

}