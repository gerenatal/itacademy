db.collection_name.find({})
db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1})
db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1, _id: 0})
db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, _id: 0, "address.zipcode": 1})
db.restaurants.find({borough: "Bronx"}, {grades: 0})
db.restaurants.find({borough: "Bronx"}, {grades: 0}).limit(5)
db.restaurants.find({borough: "Bronx"}, {grades: 0}).skip(5).limit(5)
db.restaurants.find({"grades.score": {$gt: 90}})
db.restaurants.find({"grades.score": {$gt: 80, $lt: 100}})
db.restaurants.find({"address.coord.0": {$lt: -95.754168}})
db.restaurants.find({cuisine: {$nin: ["American", "American "]}, "grades.score": {$gt: 70}, "address.coord.1": {$lt: -65.754168}}, {grades: 0})

db.restaurants.find({cuisine: {$nin: ["American", "American "]}, "grades.grade": "A", borough: {$ne: "Brooklyn"}}).sort({cuisine: -1})
db.restaurants.find({name: {$regex: /^Wil/i}}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1})
db.restaurants.find({name: {$regex: /ces$/i}}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1})
db.restaurants.find({name: {$regex: /Reg/i}}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1})
db.restaurants.find({borough: "Bronx", cuisine: {$in: ["American", "American ", "Chinese"]}}, {grades: 0})