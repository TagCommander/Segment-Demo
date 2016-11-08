//
//  TCRestaurants.h
//  TCDemo
//
//  Created by Damien TERRIER on 4/26/13.
//  Copyright (c) 2013 Damien TERRIER. All rights reserved.
//

#import <CoreFoundation/CoreFoundation.h>
#import <CoreLocation/CoreLocation.h>
#import <UIKit/UIKit.h>

@interface TCRestaurants : NSObject<CLLocationManagerDelegate>

- (NSArray *) restaurantsWithFilters: (NSArray *) filters;
+ (UIImage *) getImage: (NSDictionary *) photo;

@property (retain, nonatomic) NSArray *restaurants;
@property (retain, nonatomic) CLLocationManager *locationManager;
@property (retain, nonatomic) NSMutableArray *typesFilter;

@end
