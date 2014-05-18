<?php

namespace Carpet\Bundle\DataBundle\Entity;

use Gedmo\Mapping\Annotation as Gedmo;
use Doctrine\ORM\Mapping as ORM;

/**
 * RouteSegment
 *
 * @ORM\Table()
 * @ORM\Entity
 */
class RouteSegment
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var float
     *
     * @ORM\Column(name="start_lat", type="float")
     */
    private $startLat;

    /**
     * @var float
     *
     * @ORM\Column(name="start_lon", type="float")
     */
    private $startLon;

    /**
     * @var float
     *
     * @ORM\Column(name="end_lat", type="float")
     */
    private $endLat;

    /**
     * @var float
     *
     * @ORM\Column(name="end_lon", type="float")
     */
    private $endLon;

    /**
     * @var float
     *
     * @ORM\Column(name="distance", type="float")
     */
    private $distance;

    /**
     * @var integer
     *
     * @ORM\Column(name="duration", type="integer")
     */
    private $duration;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255)
     */
    private $description;

    /**
     * @var integer
     *
     * @ORM\Column(name="speed", type="integer")
     */
    private $speed;

    /**
     * @var datetime
     *
     * @ORM\Column(name="start", type="datetime")
     */
    private $start;


    /**
     * @var datetime
     *
     * @ORM\Column(name="end", type="datetime")
     */
    private $end;
    
    /**
     * @var datetime $created
     *
     * @Gedmo\Timestampable(on="create")
     * @ORM\Column(type="datetime")
     */
    private $created;
   

    /**
     * @ORM\ManyToOne(targetEntity="Route", inversedBy="segments")
     * @ORM\JoinColumn(name="route_id", referencedColumnName="id")
     */
    private $route;
    
    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set startLat
     *
     * @param float $startLat
     * @return RouteSegment
     */
    public function setStartLat($startLat)
    {
        $this->startLat = $startLat;

        return $this;
    }

    /**
     * Get startLat
     *
     * @return float 
     */
    public function getStartLat()
    {
        return $this->startLat;
    }

    /**
     * Set startLon
     *
     * @param float $startLon
     * @return RouteSegment
     */
    public function setStartLon($startLon)
    {
        $this->startLon = $startLon;

        return $this;
    }

    /**
     * Get startLon
     *
     * @return float 
     */
    public function getStartLon()
    {
        return $this->startLon;
    }

    /**
     * Set endLat
     *
     * @param float $endLat
     * @return RouteSegment
     */
    public function setEndLat($endLat)
    {
        $this->endLat = $endLat;

        return $this;
    }

    /**
     * Get endLat
     *
     * @return float 
     */
    public function getEndLat()
    {
        return $this->endLat;
    }

    /**
     * Set endLon
     *
     * @param float $endLon
     * @return RouteSegment
     */
    public function setEndLon($endLon)
    {
        $this->endLon = $endLon;

        return $this;
    }

    /**
     * Get endLon
     *
     * @return float 
     */
    public function getEndLon()
    {
        return $this->endLon;
    }

    /**
     * Set distance
     *
     * @param float $distance
     * @return RouteSegment
     */
    public function setDistance($distance)
    {
        $this->distance = $distance;

        return $this;
    }

    /**
     * Get distance
     *
     * @return float 
     */
    public function getDistance()
    {
        return $this->distance;
    }

    /**
     * Set duration
     *
     * @param integer $duration
     * @return RouteSegment
     */
    public function setDuration($duration)
    {
        $this->duration = $duration;

        return $this;
    }

    /**
     * Get duration
     *
     * @return integer 
     */
    public function getDuration()
    {
        return $this->duration;
    }

    /**
     * Set description
     *
     * @param string $description
     * @return RouteSegment
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string 
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set speed
     *
     * @param integer $speed
     * @return RouteSegment
     */
    public function setSpeed($speed)
    {
        $this->speed = $speed;

        return $this;
    }

    /**
     * Get speed
     *
     * @return integer 
     */
    public function getSpeed()
    {
        return $this->speed;
    }

    /**
     * Set start
     *
     * @param \DateTime $start
     * @return RouteSegment
     */
    public function setStart($start)
    {
        $this->start = $start;

        return $this;
    }

    /**
     * Get start
     *
     * @return \DateTime 
     */
    public function getStart()
    {
        return $this->start;
    }

    /**
     * Set end
     *
     * @param \DateTime $end
     * @return RouteSegment
     */
    public function setEnd($end)
    {
        $this->end = $end;

        return $this;
    }

    /**
     * Get end
     *
     * @return \DateTime 
     */
    public function getEnd()
    {
        return $this->end;
    }

    /**
     * Set created
     *
     * @param \DateTime $created
     * @return RouteSegment
     */
    public function setCreated($created)
    {
        $this->created = $created;

        return $this;
    }

    /**
     * Get created
     *
     * @return \DateTime 
     */
    public function getCreated()
    {
        return $this->created;
    }

    /**
     * Set route
     *
     * @param \Carpet\Bundle\DataBundle\Entity\Route $route
     * @return RouteSegment
     */
    public function setRoute(\Carpet\Bundle\DataBundle\Entity\Route $route = null)
    {
        $this->route = $route;

        return $this;
    }

    /**
     * Get route
     *
     * @return \Carpet\Bundle\DataBundle\Entity\Route 
     */
    public function getRoute()
    {
        return $this->route;
    }
}
