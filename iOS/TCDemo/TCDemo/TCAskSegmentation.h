#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>

@interface TCAskSegmentation : UIViewController

- (IBAction) askSegment: (UIButton *) sender;

@property (retain, nonatomic) IBOutlet UILabel *segmentList;
@property (retain, nonatomic) IBOutlet UIButton *askSegmentButton;

@end
