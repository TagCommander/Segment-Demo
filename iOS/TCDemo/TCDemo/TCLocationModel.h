//
//  TCLocationModel.m
//  Capptain Test App
//
//  Created by Damien TERRIER on 4/8/13.
//  Copyright (c) 2013 Damien TERRIER. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <MapKit/MapKit.h>

@interface TCLocationModel : NSObject <MKAnnotation>
{
    NSString *_name;
    NSString *_address;
    CLLocationCoordinate2D _coordinate;
    int _rating;
    int _waitingTime;
}

@property (copy) NSString *name;
@property (copy) NSString *address;
@property (nonatomic, readonly) CLLocationCoordinate2D coordinate;
@property (nonatomic, assign) int rating;
@property (nonatomic, assign) int waitingTime;

- (id) initWithName: (NSString*) name address: (NSString*) address coordinate: (CLLocationCoordinate2D) coordinate;

@end
