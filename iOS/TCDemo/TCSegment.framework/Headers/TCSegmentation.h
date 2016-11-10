//
// Created by JeanJulien on 04/11/2016.
// Copyright (c) 2016 TagCommander. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <TCCore/TCMacros.h>
#import <TCCore/TCSingleton.h>

#import <TCCore/TCEventListener.h>
#import <TCCore/TCEventSender.h>

@interface TCSegmentation : TCSingleton <ITCEventListenerDelegate, ITCEventSenderDelegate>

SINGLETON_CLASS_H(TCSegmentation)

- (void) setSiteID: (int) siteID andToken: (NSString *) token;
- (void) fetchSegment;
- (NSArray *) getSegments;

@property (nonatomic, assign) int siteID;
@property (nonatomic, retain) NSString *IDFA;
@property (nonatomic, retain) NSString *token;
@property (nonatomic, retain) NSMutableArray *segments;

@property (nonatomic, retain) TCEventSender *senderDelegate;
@property (nonatomic, retain) TCEventListener *listenerDelegate;

@end