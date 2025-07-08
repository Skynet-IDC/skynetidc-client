// Script to add app_id column to gb_package table and clone rows with app_id=2
require('dotenv').config();
const { sequelize } = require('./entities/Connection');

async function addAppIdToPackage() {
  try {
    console.log('Starting migration: Adding app_id to gb_package table');
    
    // Step 1: Add app_id column to gb_package table with default value 1
    console.log('Step 1: Adding app_id column...');
    await sequelize.query('ALTER TABLE gb_package ADD COLUMN app_id INT NOT NULL DEFAULT 1');
    console.log('app_id column added successfully with default value 1');
    
    // Step 2: Clone all existing rows and set app_id=2 for the cloned rows
    console.log('Step 2: Cloning rows with app_id=2...');
    await sequelize.query(`
      INSERT INTO gb_package (
        name, 
        description, 
        duration, 
        price, 
        original_price, 
        discount_percent, 
        is_hot, 
        is_active, 
        ios_product_id, 
        android_product_id, 
        position, 
        created_at, 
        updated_at, 
        app_id
      )
      SELECT 
        name, 
        description, 
        duration, 
        price, 
        original_price, 
        discount_percent, 
        is_hot, 
        is_active, 
        ios_product_id, 
        android_product_id, 
        position, 
        NOW() as created_at, 
        NOW() as updated_at, 
        2 as app_id
      FROM gb_package WHERE app_id = 1
    `);
    console.log('Rows cloned successfully with app_id=2');
    
    // Step 3: Verify the changes
    console.log('Verifying changes...');
    const [results] = await sequelize.query('SELECT id, name, app_id FROM gb_package ORDER BY id');
    console.log('Verification results:');
    console.table(results);
    
    console.log('Migration completed successfully');
  } catch (error) {
    console.error('Error during migration:', error);
  } finally {
    // Close the database connection
    await sequelize.close();
  }
}

// Run the migration
addAppIdToPackage();