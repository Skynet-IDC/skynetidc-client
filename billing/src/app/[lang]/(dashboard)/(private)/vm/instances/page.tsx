// MUI Imports
import Grid from '@mui/material/Grid2'

// Component Imports
import InstanceListTable from "@views/apps/ecommerce/instances/list/InstanceListTable";
import InstanceCard from "@views/apps/ecommerce/instances/list/InstanceCard";

/**
 * ! If you need data using an API call, uncomment the below API code, update the `process.env.API_URL` variable in the
 * ! `.env` file found at root of your project and also update the API endpoints like `/apps/ecommerce` in below example.
 * ! Also, remove the above server action import and the action itself from the `src/app/server/actions.ts` file to clean up unused code
 * ! because we've used the server action for getting our static data.
 */

const getInstanceData = async () => {
  // Vars
  const res = await fetch(`${process.env.API_URL}/apps/ecommerce`)

  if (!res.ok) {
    throw new Error('Failed to fetch ecommerce data')
  }
  // return res.json();
  return [
    {
      id: 1,
      instanceName: 'iPhone 14 Pro',
      category: 'Electronics',
      stock: true,
      sku: 19472,
      price: '$999',
      qty: 665,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-1.png',
      instanceBrand: 'Super Retina XDR display footnote Pro Motion technology'
    },
    {
      id: 2,
      instanceName: 'Echo Dot (4th Gen)',
      category: 'Electronics',
      stock: false,
      sku: 72836,
      price: '$25.50',
      qty: 827,
      status: 'Published',
      image: '/images/apps/ecommerce/product-2.png',
      instanceBrand: 'Echo Dot Smart speaker with Alexa'
    },
    {
      id: 3,
      instanceName: 'Dohioue Wall Clock',
      category: 'Accessories',
      stock: false,
      sku: 29540,
      price: '$16.34',
      qty: 804,
      status: 'Published',
      image: '/images/apps/ecommerce/product-3.png',
      instanceBrand: 'Modern 10 Inch Battery Operated Wall Clocks'
    },
    {
      id: 4,
      instanceName: 'INZCOU Running Shoes',
      category: 'Shoes',
      stock: false,
      sku: 49402,
      price: '$36.98',
      qty: 528,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-4.png',
      instanceBrand: 'Lightweight Tennis Shoes Non Slip Gym Workout Shoes'
    },
    {
      id: 5,
      instanceName: 'Apple Watch Series 7',
      category: 'Office',
      stock: false,
      sku: 46658,
      price: '$799',
      qty: 851,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-5.png',
      instanceBrand: 'Starlight Aluminum Case with Starlight Sport Band.'
    },
    {
      id: 6,
      instanceName: 'Meta Quest 2',
      category: 'Office',
      stock: true,
      sku: 57640,
      price: '$299',
      qty: 962,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-6.png',
      instanceBrand: 'Advanced All-In-One Virtual Reality Headset'
    },
    {
      id: 7,
      instanceName: 'MacBook Pro 16',
      category: 'Electronics',
      stock: true,
      sku: 92885,
      price: '$2648.95',
      qty: 965,
      status: 'Published',
      image: '/images/apps/ecommerce/product-7.png',
      instanceBrand: 'Laptop M2 Pro chip with 12‑core CPU and 19‑core GPU'
    },
    {
      id: 8,
      instanceName: 'SAMSUNG Galaxy S22 Ultra',
      category: 'Electronics',
      stock: true,
      sku: 75257,
      price: '$899',
      qty: 447,
      status: 'Published',
      image: '/images/apps/ecommerce/product-8.png',
      instanceBrand: 'Android Smartphone, 256GB, 8K Camera'
    },
    {
      id: 9,
      instanceName: 'Air Jordan',
      category: 'Shoes',
      stock: false,
      sku: 31063,
      price: '$125',
      qty: 942,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-9.png',
      instanceBrand: 'Air Jordan is a line of basketball shoes produced by Nike'
    },
    {
      id: 10,
      instanceName: 'VISKABACKA',
      category: 'Home Decor',
      stock: false,
      sku: 91848,
      price: '$190.45',
      qty: 133,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-10.png',
      instanceBrand: 'Armchair, Skartofta black/light grey'
    },
    {
      id: 11,
      instanceName: 'Nintendo Switch',
      category: 'Games',
      stock: true,
      sku: 52575,
      price: '$296.99',
      qty: 870,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-11.png',
      instanceBrand: 'TV Mode, Tabletop Mode, Handheld Mode'
    },
    {
      id: 12,
      instanceName: 'PlayStation 5',
      category: 'Games',
      stock: true,
      sku: 59551,
      price: '$499',
      qty: 145,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-12.png',
      instanceBrand: 'Marvel at incredible graphics and experience'
    },
    {
      id: 13,
      instanceName: 'Amazon Fire TV',
      category: 'Electronics',
      stock: false,
      sku: 5829,
      price: '$263.49',
      qty: 587,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-13.png',
      instanceBrand: '4K UHD smart TV, stream live TV without cable'
    },
    {
      id: 14,
      instanceName: 'Smiletag Ceramic Vase',
      category: 'Home Decor',
      stock: false,
      sku: 24456,
      price: '$34.99',
      qty: 310,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-14.png',
      instanceBrand: 'Modern Farmhouse Decor Vase Set of 3'
    },
    {
      id: 15,
      instanceName: 'Apple iPad',
      category: 'Electronics',
      stock: true,
      sku: 35946,
      price: '$248.39',
      qty: 468,
      status: 'Published',
      image: '/images/apps/ecommerce/product-15.png',
      instanceBrand: '10.2-inch Retina Display, 64GB'
    },
    {
      id: 16,
      instanceName: 'BANGE Anti Theft Backpack',
      category: 'Office',
      stock: true,
      sku: 41867,
      price: '$79.99',
      qty: 519,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-16.png',
      instanceBrand: 'Smart Business Laptop Fits 15.6 Inch Notebook'
    },
    {
      id: 17,
      instanceName: 'Xbox Series X/S',
      category: 'Games',
      stock: true,
      sku: 43224,
      price: '$49.99',
      qty: 787,
      status: 'Published',
      image: '/images/apps/ecommerce/product-17.png',
      instanceBrand: 'Dual Controller Charger Station Dock'
    },
    {
      id: 18,
      instanceName: 'Canon EOS Rebel T7',
      category: 'Electronics',
      stock: true,
      sku: 63474,
      price: '$399',
      qty: 810,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-18.png',
      instanceBrand: '18-55mm Lens | Built-in Wi-Fi | 24.1 MP CMOS Sensor'
    },
    {
      id: 19,
      instanceName: 'Honiway Wall Mirror',
      category: 'Home Decor',
      stock: false,
      sku: 15859,
      price: '$23.99',
      qty: 735,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-19.png',
      instanceBrand: 'Decorative 12 inch Rustic Wood Mirror Sunburst Boho'
    },
    {
      id: 20,
      instanceName: 'Tommaso Veloce Shoes',
      category: 'Shoes',
      stock: false,
      sku: 28844,
      price: '$922.09',
      qty: 294,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-20.png',
      instanceBrand: 'Peloton Shoes Triathlon Road Bike Indoor Cycling'
    },
    {
      id: 21,
      instanceName: 'Zoolab',
      category: 'Accessories',
      stock: true,
      sku: 99009,
      price: '$719.13',
      qty: 927,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-1.png',
      instanceBrand: 'Cruickshank-Jones'
    },
    {
      id: 22,
      instanceName: 'Viva',
      category: 'Home Decor',
      stock: false,
      sku: 53795,
      price: '$775.80',
      qty: 442,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-2.png',
      instanceBrand: 'Ferry Group'
    },
    {
      id: 23,
      instanceName: 'Transcof',
      category: 'Shoes',
      stock: true,
      sku: 77663,
      price: '$817.60',
      qty: 256,
      status: 'Published',
      image: '/images/apps/ecommerce/product-3.png',
      instanceBrand: 'Bruen-Heathcote'
    },
    {
      id: 24,
      instanceName: 'Uerified',
      category: 'Accessories',
      stock: false,
      sku: 45282,
      price: '$167.19',
      qty: 728,
      status: 'Published',
      image: '/images/apps/ecommerce/product-4.png',
      instanceBrand: 'Koch Group'
    },
    {
      id: 25,
      instanceName: 'Y-find',
      category: 'Home Decor',
      stock: false,
      sku: 5622,
      price: '$189.77',
      qty: 445,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-5.png',
      instanceBrand: 'Emmerich and Sons'
    },
    {
      id: 26,
      instanceName: 'Wigtax',
      category: 'Accessories',
      stock: true,
      sku: 38920,
      price: '$411.46',
      qty: 857,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-6.png',
      instanceBrand: 'Zulauf-Prohaska'
    },
    {
      id: 27,
      instanceName: 'Tempsoft',
      category: 'Accessories',
      stock: true,
      sku: 78211,
      price: '$961.76',
      qty: 975,
      status: 'Published',
      image: '/images/apps/ecommerce/product-7.png',
      instanceBrand: 'VonRueden, Rogahn and Kris'
    },
    {
      id: 28,
      instanceName: 'Rt',
      category: 'Accessories',
      stock: true,
      sku: 98552,
      price: '$514.14',
      qty: 39,
      status: 'Published',
      image: '/images/apps/ecommerce/product-8.png',
      instanceBrand: "Romaguera, O'Connell and Abernathy"
    },
    {
      id: 29,
      instanceName: 'Zontrax',
      category: 'Shoes',
      stock: true,
      sku: 7151,
      price: '$591.30',
      qty: 74,
      status: 'Published',
      image: '/images/apps/ecommerce/product-9.png',
      instanceBrand: 'Mills, Hagenes and Bednar'
    },
    {
      id: 30,
      instanceName: 'Keylex',
      category: 'Accessories',
      stock: true,
      sku: 79571,
      price: '$928.07',
      qty: 245,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-10.png',
      instanceBrand: 'Sanford, Harvey and Parisian'
    },
    {
      id: 31,
      instanceName: 'Trippledex',
      category: 'Home Decor',
      stock: false,
      sku: 51597,
      price: '$312.03',
      qty: 657,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-11.png',
      instanceBrand: 'Conroy-Bergstrom'
    },
    {
      id: 32,
      instanceName: 'Opela',
      category: 'Accessories',
      stock: true,
      sku: 6506,
      price: '$951.29',
      qty: 770,
      status: 'Published',
      image: '/images/apps/ecommerce/product-12.png',
      instanceBrand: 'Langosh Inc'
    },
    {
      id: 33,
      instanceName: 'Span',
      category: 'Shoes',
      stock: false,
      sku: 33523,
      price: '$600.43',
      qty: 622,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-13.png',
      instanceBrand: 'Jerde-Walsh'
    },
    {
      id: 34,
      instanceName: 'Rank',
      category: 'Accessories',
      stock: false,
      sku: 60307,
      price: '$337.90',
      qty: 896,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-14.png',
      instanceBrand: 'Barrows, Quitzon and Roberts'
    },
    {
      id: 35,
      instanceName: 'Tempsoft',
      category: 'Accessories',
      stock: true,
      sku: 75059,
      price: '$959.47',
      qty: 239,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-15.png',
      instanceBrand: 'Russel-Grant'
    },
    {
      id: 36,
      instanceName: 'Ventosanzap',
      category: 'Accessories',
      stock: true,
      sku: 69072,
      price: '$756.81',
      qty: 410,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-16.png',
      instanceBrand: "O'Conner-Zboncak"
    },
    {
      id: 37,
      instanceName: 'Mat Lam Tam',
      category: 'Accessories',
      stock: false,
      sku: 68290,
      price: '$256.86',
      qty: 630,
      status: 'Published',
      image: '/images/apps/ecommerce/product-17.png',
      instanceBrand: 'Rutherford, Heller and Bashirian'
    },
    {
      id: 38,
      instanceName: 'Zamit',
      category: 'Shoes',
      stock: true,
      sku: 89552,
      price: '$378.54',
      qty: 247,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-18.png',
      instanceBrand: 'Swift-Altenwerth'
    },
    {
      id: 39,
      instanceName: 'Tresom',
      category: 'Shoes',
      stock: true,
      sku: 50863,
      price: '$166.17',
      qty: 672,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-19.png',
      instanceBrand: "O'Kon, Waelchi and Lesch"
    },
    {
      id: 40,
      instanceName: 'Viva',
      category: 'Accessories',
      stock: false,
      sku: 90484,
      price: '$745.76',
      qty: 697,
      status: 'Published',
      image: '/images/apps/ecommerce/product-20.png',
      instanceBrand: 'Johnston, Anderson and Metz'
    },
    {
      id: 41,
      instanceName: 'Matsoft',
      category: 'Accessories',
      stock: true,
      sku: 76980,
      price: '$603.16',
      qty: 74,
      status: 'Published',
      image: '/images/apps/ecommerce/product-1.png',
      instanceBrand: "O'Conner, Paucek and Braun"
    },
    {
      id: 42,
      instanceName: 'Wiodex',
      category: 'Home Decor',
      stock: true,
      sku: 66971,
      price: '$772.51',
      qty: 280,
      status: 'Published',
      image: '/images/apps/ecommerce/product-2.png',
      instanceBrand: 'Wisoky-Kassulke'
    },
    {
      id: 43,
      instanceName: 'Keylex',
      category: 'Shoes',
      stock: false,
      sku: 16589,
      price: '$986.22',
      qty: 758,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-3.png',
      instanceBrand: 'Haag, Bruen and Reichel'
    },
    {
      id: 44,
      instanceName: 'Konklux',
      category: 'Accessories',
      stock: true,
      sku: 73896,
      price: '$988.47',
      qty: 14,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-4.png',
      instanceBrand: 'Ankunding Inc'
    },
    {
      id: 45,
      instanceName: 'Tresom',
      category: 'Accessories',
      stock: false,
      sku: 67489,
      price: '$946.62',
      qty: 35,
      status: 'Inactive',
      image: '/images/apps/ecommerce/product-5.png',
      instanceBrand: 'Deckow and Sons'
    },
    {
      id: 46,
      instanceName: 'Quo Lux',
      category: 'Shoes',
      stock: true,
      sku: 48177,
      price: '$224.28',
      qty: 935,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-1.png',
      instanceBrand: 'Kreiger, Reynolds and Sporer'
    },
    {
      id: 47,
      instanceName: 'Roldlamis',
      category: 'Home Decor',
      stock: true,
      sku: 225,
      price: '$952.14',
      qty: 361,
      status: 'Published',
      image: '/images/apps/ecommerce/product-6.png',
      instanceBrand: 'Kuphal-Abbott'
    },
    {
      id: 48,
      instanceName: 'Tampflex',
      category: 'Accessories',
      stock: false,
      sku: 29438,
      price: '$646.21',
      qty: 908,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-7.png',
      instanceBrand: 'Romaguera, Schmeler and Volkman'
    },
    {
      id: 49,
      instanceName: 'Span',
      category: 'Home Decor',
      stock: true,
      sku: 55666,
      price: '$583.13',
      qty: 898,
      status: 'Scheduled',
      image: '/images/apps/ecommerce/product-1.png',
      instanceBrand: 'Hane-Romaguera'
    },
    {
      id: 50,
      instanceName: 'Zamit',
      category: 'Accessories',
      stock: false,
      sku: 55860,
      price: '$273.67',
      qty: 332,
      status: 'Published',
      image: '/images/apps/ecommerce/product-9.png',
      instanceBrand: 'Hoeger-Powlowski'
    }
  ];
}

const instancesList = async () => {
  const data = await getInstanceData()

  return (
    <Grid container spacing={6}>
      <Grid size={{ xs: 12 }}>
        <InstanceCard />
      </Grid>
      <Grid size={{ xs: 12 }}>
        <InstanceListTable instanceData={data} />
      </Grid>
    </Grid>
  )
}

export default instancesList
