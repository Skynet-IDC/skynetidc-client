const levelRepository = require('../repositories/LevelRepository');
const ErrorCode = require('../constants/ErrorCode');

module.exports = {

    getLevelList: async function () {
        const levelList = await levelRepository.findAllActiveLevel();
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {items: levelList}};
    },

}