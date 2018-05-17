import pandas as pd
import numpy
from sklearn.svm import SVR
from matplotlib import pyplot as plt
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import mean_squared_error
import matplotlib.pyplot as plt
scaler = StandardScaler()
df = pd.read_csv('Agm_new.csv')
X_true = pd.get_dummies(df)
Y_true = numpy.array(X_true['Modal Price (Rs./Quintal)'])
X_true = X_true.drop('Modal Price (Rs./Quintal)',axis=1)
X_train,X_test,Y_train,Y_test = train_test_split(X_true,Y_true,test_size=0.25,random_state=42)
scaler.fit(X_train)
scaler.transform(X_test)
clf = SVR(kernel='rbf',C=1e3,gamma=0.001)
#hyp = clf.fit(X_train,Y_train)
#score = cross_val_score(clf,X_true,Y_true,cv=10)
#print(score)
clf.fit(X_train,Y_train)
pred = clf.predict(X_test)
error = abs(pred - Y_test)
quil = 100*(numpy.sum(error)/numpy.sum(Y_test))
accuracy = 100 - numpy.mean(quil)
print(accuracy,"%")
f = open('Accuracy.csv','a')
f.write(str(accuracy) + ',')
f.close()
#estimator = numpy.arange(0.001,0.01,0.001)
#score = list()
#for i in estimator:
#    clf = SVR(kernel='rbf',C=1e3,gamma=i)
#    clf.fit(X_train,Y_train)
#    abc = cross_val_score(clf,X_true,Y_true,cv=10)
#    score.append(numpy.mean(abc))
#plt.xlabel('gamma')
#plt.ylabel('cv_score_mean')
#plt.plot(estimator,score)
#plt.show()